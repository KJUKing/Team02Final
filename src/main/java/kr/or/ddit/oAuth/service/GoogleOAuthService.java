package kr.or.ddit.oAuth.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;

import com.google.api.client.auth.oauth2.Credential;

public interface GoogleOAuthService {
	

	public String getAuthorizationUrl() throws FileNotFoundException, IOException, GeneralSecurityException;
	
	public Credential getCredentialFromCode(String code) throws IOException ;
	
	

}
