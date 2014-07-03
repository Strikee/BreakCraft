package com.breakcraft.objects;

public class Account {

	private String userName;
	private String userEmail;
	private String userPassword;
	private String userUUID;
	private String userToken;

	public Account(String args[]){
		
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserEmail(String eMail) {
		this.userEmail = eMail;
	}
	
	public String getUserEmail() {
		return this.userEmail;
	}
	
	public void setPassword(String password) {
		this.userPassword = password;
	}
	
	public String getPassword() {
		return this.userPassword;
	}
	
	public void setUUID(String uuid) {
		this.userUUID = uuid;
	}
	
	public String getUUID() {
		return this.userUUID;
	}
	
	public void setUserToken(String token) {
		this.userToken = token;
	}
	
	public String getUserToken() {
		return this.userToken;
	}
}
