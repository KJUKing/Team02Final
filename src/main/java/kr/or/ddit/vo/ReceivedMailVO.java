package kr.or.ddit.vo;

import lombok.Data;

@Data
public class ReceivedMailVO {
	private String rmailAccount; // 메일주소
	private String empId; // 사원아이디
	private String rmailMessageid; // 메일의 아이디(구글)
	private String rmailTitle; // 메일 제목
	private String rmailDate; // 메일수신날짜
	private String rmailFrom; // 메일발신자
	private String rmailCalltime;  // api 호출 시간
	

	
	
}
