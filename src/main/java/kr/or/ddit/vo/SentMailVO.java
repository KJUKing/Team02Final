package kr.or.ddit.vo;

import lombok.Data;

@Data
public class SentMailVO {
	private String smailAccount; // 메일주소
	private String empId; // 사원아이디
	private String smailMessageid; // 메일의 아이디(구글)
	private String smailTitle; // 메일 제목
	private String smailDate; // 메일발신날짜
	private String smailFrom; // 메일수신자
	private String smailCalltime;  // api 호출 시간

}
