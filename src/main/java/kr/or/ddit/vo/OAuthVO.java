package kr.or.ddit.vo;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OAuthVO {
	private String memId;
	private String email;
	private String AccessToken;
	private String RefreshToken;
}
