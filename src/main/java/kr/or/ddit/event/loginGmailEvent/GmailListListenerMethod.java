package kr.or.ddit.event.loginGmailEvent;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.gson.GsonFactory;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import kr.or.ddit.vo.OAuthVO;
import kr.or.ddit.vo.ReceivedMailVO;
import kr.or.ddit.vo.SentMailVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class GmailListListenerMethod {
	private HttpRequestFactory requestFactory;
	private HttpHeaders headers;
	private String nowString;
	private String gmailApiListUrl;
	
	@PostConstruct
	public void init() {
		this.requestFactory = new NetHttpTransport().createRequestFactory();
		this.headers = new HttpHeaders();
		this.gmailApiListUrl = "https://gmail.googleapis.com/gmail/v1/users/me/messages%s";
	}
	
	
	public String getMailList(String q, OAuthVO myOAuth) throws IOException {
//		try {
		// 메일 리스트를 가지고 오는 api 주소
		// 여기에 사용되는 "me"는 google api에서 사용하는 로그인되어있는 사용자를 칭함!
		// ?q의 바라미터 부분이 없으면 모든 list 를 다 가지고 와버림, label:inbox하면 수신메일 label:sent하면 발신메일

		String userAccessToken = myOAuth.getAccessToken();
		String getMailListapiurl = String.format(gmailApiListUrl, q);

		GenericUrl listUrl = new GenericUrl(getMailListapiurl);
		// 여기서 잠깐!!!
		// api document에 있는 쿼리매개변수 사용하고 싶으면 url에 put
		// mail list를 가지고 오는 api에 설정할 수 있는 쿼리매개변수 종류에는
		// maxResults(type : integer) : 반환할 최대 메세지 수(기본값 100, 최댓값 500)
		// pageToken(type : string) : 목록에서 특정 결과 페이지를 검색하는 페이지 토큰
		// q(type : string) : 지정된 쿼리와 일치하는 메세지만 반환(gmail 검색창기능..?)
		// labelIds[](type : string) : 지정된 모든 라벨 od와 일치하는 라벨 메일만 반환(중요메일에서사용)
		// includeSpamTrash(type:boolean) : 결과에 spam, trash에서 보낸 메세지 포함
		// url.put("maxResults", 10);

		// 요청 생성
		HttpRequest listRequest = requestFactory.buildGetRequest(listUrl);
		// 요청의 헤더 설정(oauth를 통한 api 호출에는 무조건 헤어설정이 필요함!!!!!!)
		headers.setAuthorization("Bearer " + userAccessToken); // Authorization 헤더 추가
		headers.setAccept("application/json"); // JSON 형식 요청

		// 생성한 요청에 header 셋팅하기
		listRequest.setHeaders(headers);

		/*
		 * 요청 실행 + 응답 파싱(모~~든 응답은 json 형태로 넘어옴) { "messages": [ { "id": "메일 한 개의 id",
		 * "threadId": "그 메일의 스레드 id"(우리가 아는 그 스레드랑 개념이 다름 우린 안 쓸거임) }, ... ] }
		 */
		listRequest.setParser(new JsonObjectParser(GsonFactory.getDefaultInstance()));
		// 지금 시간 가져와서 저장해야함!!
		LocalDateTime now = LocalDateTime.now();
		nowString = now.toString();
		// request.execute() 실행
		return listRequest.execute().parseAsString();
	}

	public <T> void saveDataBase(String mailListResponse, OAuthVO myOAuth, Class<T> voClass) throws IOException {

		// 여기까지가 메일의 list를 가지고 오는 api를 호출하고, mailListResponse로 담은 코드...........

		// response에 mail의 id, thread id를 담은 json 객체 담겨져있음
		// Json 파싱 후 메일 리스트에서 id를 꺼내고, 그 id로 api를 호출해야함ㅠㅠ
		// api를 통해 가지고 온 데이터에서 보낸 사람, 제목, 날짜를 끄내서 ReceivedMailVO에 담아서 insert 해야함
		JsonObject jsonResponse = JsonParser.parseString(mailListResponse).getAsJsonObject();
		JsonArray messages = jsonResponse.getAsJsonArray("messages");

		List<T> receivedMailList = new ArrayList<>();

		if (messages == null || messages.size() == 0) {
			// 메세지가 없을 경우!!!!!!!!!!!!!!!!!!!!!!!!!
		} else {

			// 각각의 메일 상세 정보 가져오기
			for (JsonElement messageElement : messages) {
				String messageId = messageElement.getAsJsonObject().get("id").getAsString();
				String messageApiUrl = String.format(gmailApiListUrl, "/" + messageId);

				GenericUrl detailUrl = new GenericUrl(messageApiUrl);
				HttpRequest detailRequest = requestFactory.buildGetRequest(detailUrl);
				// list 요청과 동일한 header를 그대로 설정
				detailRequest.setHeaders(headers);

				detailRequest.setParser(new JsonObjectParser(GsonFactory.getDefaultInstance()));
				String detailResponse = detailRequest.execute().parseAsString();

				JsonObject messageJson = JsonParser.parseString(detailResponse).getAsJsonObject();
				JsonObject payload = messageJson.getAsJsonObject("payload");
				JsonArray headersArray = payload.getAsJsonArray("headers");
				
				String from = null;
				String title = null;
				String date = null;

				// 헤더에서 필요한 정보 추출

				for (JsonElement headerElement : headersArray) {
					JsonObject header = headerElement.getAsJsonObject();
					String name = header.get("name").getAsString();
					if ("From".equalsIgnoreCase(name)) {
						from = header.get("value").getAsString();
					} else if ("Subject".equalsIgnoreCase(name)) {
						title = header.get("value").getAsString();
					} else if ("Date".equalsIgnoreCase(name)) {
						date = header.get("value").getAsString();
					}
				}
				String employeeId = myOAuth.getMemId();
				String employeeMail = myOAuth.getEmail();
				// 메일 정보를 VO에 저장

				if (voClass.equals(ReceivedMailVO.class)) {
					ReceivedMailVO receivedMail = 
							setReceivedMail(
									employeeId, employeeMail, from, title, 
									date, messageId, nowString
							);
//					ReceivedMailVO receivedMail = new ReceivedMailVO();
//					receivedMail.setEmpId(employeeId); // 적절한 empId 설정
//					receivedMail.setRmailAccount(employeeMail);
//					receivedMail.setRmailFrom(from);
//					receivedMail.setRmailTitle(title);
//					receivedMail.setRmailDate(date);
//					receivedMail.setRmailId(messageId);
//					receivedMail.setRmailCalltime(nowString);
					receivedMailList.add((T)receivedMail);
				} else {
					SentMailVO sentMail = 
							setSentMail(
									employeeId, employeeMail, from, title, 
									date, messageId, nowString
							);
					receivedMailList.add((T) sentMail);
				}

			}
			log.info("❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️{} : {}", voClass.getSimpleName() ,receivedMailList);

			// 위 데이터를 가지고 data base에 insert 하기
		}
	}
	
	public ReceivedMailVO setReceivedMail(
			String employeeId, String employeeMail, String from, String title,
			String date, String messageId, String nowString2
	){
		ReceivedMailVO receivedMail = new ReceivedMailVO();
		receivedMail.setEmpId(employeeId); // 적절한 empId 설정
		receivedMail.setRmailAccount(employeeMail);
		receivedMail.setRmailFrom(from);
		receivedMail.setRmailTitle(title);
		receivedMail.setRmailDate(date);
		receivedMail.setRmailMessageid(messageId);
		receivedMail.setRmailCalltime(nowString);
		
		// service랑 연동해서 insert 쳐야함
		
		return receivedMail;
		
	}
	
	public SentMailVO setSentMail(
			String employeeId, String employeeMail, String from, String title,
			String date, String messageId, String nowString2
			){
		SentMailVO sentMail = new SentMailVO();
		sentMail.setEmpId(employeeId); // 적절한 empId 설정
		sentMail.setSmailAccount(employeeMail);
		sentMail.setSmailFrom(from);
		sentMail.setSmailTitle(title);
		sentMail.setSmailDate(date);
		sentMail.setSmailMessageid(messageId);
		sentMail.setSmailCalltime(nowString);
		
		// service랑 연동해서 insert 쳐야함
		
		return sentMail;
		
	}

}
