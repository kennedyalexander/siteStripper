package com.slotMachine.services;

import java.util.List;

import com.slotMachine.models.UserDetails;
import com.slotMachine.models.UserPlay;

public interface DataAccessService {

	void logRoll(UserPlay spin);
	void addUser(UserDetails userDetails);
	UserDetails getUser(String username);
	List<UserPlay> getPlaysForUser(String username);
	
}
