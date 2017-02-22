package com.slotMachine.models;

import java.io.Serializable;

public class UserRequest{
	String username;
	String userToken;
	Integer userBet;
	
	public UserRequest(){
		this.username = "user";
		this.userToken = "usertoken";
		this.userBet = 0;
	}

	public UserRequest(String username, String userToken) {
		this.username = username;
		this.userToken = userToken;
		this.userBet = 0;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the userToken
	 */
	public String getUserToken() {
		return userToken;
	}

	/**
	 * @return the userBet
	 */
	public Integer getUserBet() {
		return userBet;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param userToken the userToken to set
	 */
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	/**
	 * @param userBet the userBet to set
	 */
	public void setUserBet(Integer userBet) {
		this.userBet = userBet;
	}

}