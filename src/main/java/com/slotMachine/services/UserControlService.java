package com.slotMachine.services;

import java.util.List;

import com.slotMachine.models.UserDetails;

public interface UserControlService {
	
	int login(String user);
	void addUser(UserDetails user);
	void removeUser(String username);
	void modifyUser(UserDetails user);
	UserDetails getUser(String username);
	List<UserDetails> getAllUsers();

}
