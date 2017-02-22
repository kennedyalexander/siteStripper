package com.slotMachine.models;

import java.io.Serializable;

public class UserPlay implements Serializable{
	Spin userSpin;
	UserRequest userRequest;
	
	public UserPlay() {
		this.userSpin = new Spin();
		this.userRequest = new UserRequest();
	}

	
	public UserPlay(Spin newSpin, UserRequest newRequest) {
		this.userSpin = newSpin;
		this.userRequest = newRequest;
	}

	/**
	 * @return the userSpin
	 */
	public Spin getUserSpin() {
		return userSpin;
	}

	/**
	 * @return the userRequest
	 */
	public UserRequest getUserRequest() {
		return userRequest;
	}

}
