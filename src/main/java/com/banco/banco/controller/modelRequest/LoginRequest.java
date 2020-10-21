package com.banco.banco.controller.modelRequest;

public class LoginRequest {

	private String identication;
	
	private String passLogin;

	public LoginRequest(String identication, String passLogin) {
		this.identication = identication;
		this.passLogin = passLogin;
	}

	public String getIdentication() {
		return identication;
	}

	public void setIdentication(String identication) {
		this.identication = identication;
	}

	public String getPassLogin() {
		return passLogin;
	}

	public void setPassLogin(String passLogin) {
		this.passLogin = passLogin;
	}
	
	
	
	
}
