package kr.or.ddit.event.loginGmailEvent;

import java.io.IOException;

import javax.inject.Inject;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import kr.or.ddit.gmail.service.GoogleOAuthCheckServiceImpl;
import kr.or.ddit.vo.OAuthVO;
import kr.or.ddit.vo.SentMailVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableAsync
@Component
public class GmailSentListEventListener {

	@Inject
	private GoogleOAuthCheckServiceImpl googleOAuthCheckServie;
	@Inject
	private GmailListListenerMethod gmailListMethod;


	@EventListener
	@Async
	public void getInboxMailList(LoginSuccessEvent event) {
		OAuthVO myOAuth = googleOAuthCheckServie.getUsableAccessToken(event.getMyOAuth());
		
		
		// email주소로 저장된 받은 메일, 보낸 메일 테이블에 있는 데이터 중에 중 가장 마지막 날짜를 가지고 와야함
		// 나의 mailId를 통해 data base에 접근해서 나의 mail id로 insert가 되어있는 내용이 있는지 없는지를 우선 확인
		// 나의 mail id로 되어있는 내용이 없을 때는 처음 조회하는 거기 때문에 쿼리파라미터에 기간에 대한 정보가 추가되지 않고
		// 나의 mail id로 되어있는 내용이 있을 때는 그 리스트 중 가장 마지막 날짜의 데이터를 가지고 와서 쿼리마라미터에 추가해야함
		

		
		// 받은 메일함을 불러오는 api의 쿼리파라미터
		String sentQ;
		
		String mailId = myOAuth.getEmail();
//		if(데이버베이스에서 조회한 send mail list가 없다면) {
			sentQ = "?q=label:sent";
//		} else {
			// 데이터 베이스에서 조회한 list가 있다면
			// 데이터 베이스에서 조회한 마지막 날짜 기준의 rmailCalltime
//			ReceivedMailVO receivedMail = new ReceivedMailVO();
			// receivedMail.getRmailCalltime()을 LocalDateTime으로 파싱
//	        LocalDateTime dateTime = LocalDateTime.parse(receivedMail.getRmailCalltime());
	        // 유닉스 타임스탬프 (초 단위)로 변환 (UTC 기준)
//	        long unixTimestamp = dateTime.toEpochSecond(ZoneOffset.UTC);
			
//			sentQ = "?q=label:sent after:"+unixTimestamp;
//			
//		}


		
		try {
			// 받은 메일의 list를 가지고 오는 메소드
			String mailSentListResponse = gmailListMethod.getMailList(sentQ, myOAuth);
			// 받은 메일의 list를 하나씩 빼서 vo에 담는 메소드
			gmailListMethod.saveDataBase(mailSentListResponse, myOAuth, SentMailVO.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
