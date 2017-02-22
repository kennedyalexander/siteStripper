package com.slotMachine.models;

public class UserDetails {
	String username;
	String password;
	String email;
	Integer active;
	Integer winnings;
	
	public UserDetails(){
		this.username = "";
		this.password = "";
		this.email = "";
		this.active = 0;
		this.winnings = 0;
	}
	public UserDetails(String username, String password, String email, Integer active, Integer winnings) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.active = active;
		this.winnings = winnings;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @return the active
	 */
	public Integer getActive() {
		return active;
	}
	/**
	 * @return the winnings
	 */
	public Integer getWinnings() {
		return winnings;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(Integer active) {
		this.active = active;
	}
	/**
	 * @param winnings the winnings to set
	 */
	public void setWinnings(Integer winnings) {
		this.winnings = winnings;
	}
	
}
