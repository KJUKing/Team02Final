package kr.or.ddit.oAuth.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;

@Service
public class GoogleOAuthServiceImpl implements GoogleOAuthService {

	private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

	private static final String TOKENS_DIRECTORY_PATH = "tokens";
	// 허용 범위
	private static final List<String> SCOPES = Arrays.asList(
			// gmail api
			// 민감하지 않은 범위
			// 임시보관된 이메일 관리 및 이메일 전송
			"https://www.googleapis.com/auth/gmail.addons.current.action.compose",
			// 사용자가 부가기능과 상호작용할 때 이메일 메시지 보기
			"https://www.googleapis.com/auth/gmail.addons.current.message.action",
			// 이메일 라벨 확인 및 수정
			"https://www.googleapis.com/auth/gmail.labels",

			// 민감한 범위
			// 부가기능 실행 시 이메일 메시지 메타데이터 확인
			"https://www.googleapis.com/auth/gmail.addons.current.message.metadata",
			// 부가기능 실행 시 이메일 메시지 보기
			"https://www.googleapis.com/auth/gmail.addons.current.message.readonly",
			// 나를 대신하여 이메일 전송
			"https://www.googleapis.com/auth/gmail.send",

			// 제한된 범위
			// Gmail에서 모든 이메일 확인, 작성, 전송, 영구 삭제
			"https://mail.google.com/",
			// Gmail 계정에서 이메일 읽기, 작성 및 전송
			"https://www.googleapis.com/auth/gmail.modify",
			// 임시보관 메일 관리 및 이메일 전송
			"https://www.googleapis.com/auth/gmail.compose",
			// 이메일 메시지 및 설정 보기
			"https://www.googleapis.com/auth/gmail.readonly",
			// Gmail 편지함에 이메일 추가
			"https://www.googleapis.com/auth/gmail.insert",
			// Gmail의 이메일 설정 및 필터 확인, 수정, 생성 또는 변경
			"https://www.googleapis.com/auth/gmail.settings.basic",
			// 내 메일을 관리할 수 있는 사용자를 포함한 중요한 메일 설정 관리
			"https://www.googleapis.com/auth/gmail.settings.sharing",
			
			// google user info api
			// 계정 정보(이메일) 가지고 오는 scope
			"https://www.googleapis.com/auth/userinfo.email");
	
	// Google OAuth 클라이언트 인증 정보 파일 경로
	private static final String CREDENTIALS_FILE_PATH = "C:/Dev/dev_finalProject/googleoauthconfig/credentials.json";
	// 클라이언트 인증 정보 객체 (Google Client Secrets)
	private GoogleClientSecrets clientSecrets;
	// Google Authorization Flow 객체 (인증 및 토큰 관리)
	private GoogleAuthorizationCodeFlow flow;
	
	@PostConstruct
	public void init() throws FileNotFoundException, IOException, GeneralSecurityException {
		// 클라이언트 인증 정보 로드 (JSON 파일에서 읽음)
		clientSecrets = GoogleClientSecrets.load(GsonFactory.getDefaultInstance(),
				new InputStreamReader(new FileInputStream(CREDENTIALS_FILE_PATH)));
		
		// Authorization Flow를 초기화
		flow = new GoogleAuthorizationCodeFlow.Builder(
				GoogleNetHttpTransport.newTrustedTransport(), GsonFactory.getDefaultInstance(), clientSecrets, SCOPES)
						.setDataStoreFactory(new FileDataStoreFactory(new File(TOKENS_DIRECTORY_PATH)))
						.setAccessType("offline").build();
	}


	
	@Override
	public String getAuthorizationUrl() throws FileNotFoundException, IOException, GeneralSecurityException {
		// 리디렉션 URI(인증을 위한 URL)
		String redirectionUri = flow.newAuthorizationUrl()
									// 인증 요청 URL을 생성하고 리디렉션 URI 설정
									.setRedirectUri("https://localhost/work2gether/google-oauthcheck.do")
									// 한 번 인증한 계정의 경우 두 번째 인증 요청시에는 refresh token이 자동 발급되지 않음..!!
									// 그래서 회원가입을 할 때 구글 계정 인증 절차까지는 완료했다가 어떠한 이유로 회원가입을 마무리 하지 않았다면
									// 다시 회원가입을 하려고 다시 구글 계정 인증 요청을 할 때 refresh token은 발급되지 않음
									// 그래서 인증 요청을 할 때마다 refresh token이 새로 발급되도록 하는 설정이 필요함
									// prompt=consent가 그 설정임
									// 만약 이쪽에서 충돌이 일어나거나 생각하는대로 코드 실행이 되지 않는다면
									// controller에서 credential 객체를 통해 refresh token과 access token을 확인할 때
									// refresh token null 체크를 하고 null이라면 다시 추가 인증을 하는 로직을 구현해야함!!
									.set("prompt", "consent")
									// 최종적으로 url을 발급
									.build();
		return redirectionUri;
	}

	@Override
	public Credential getCredentialFromCode(String code) throws IOException {		
		// 인증 코드()로 액세스 토큰을 요청하고 GoogleTokenResponse를 얻음
		GoogleTokenResponse tokenResponse =
				flow.newTokenRequest(code)
					.setRedirectUri("https://localhost/work2gether/google-oauthcheck.do") // 리디렉션 URI
					.execute();

		// GoogleTokenResponse를 Credential로 변환
		Credential credential = flow.createAndStoreCredential(tokenResponse, "user");

		return credential; // Credential 객체 반환

	}

}
