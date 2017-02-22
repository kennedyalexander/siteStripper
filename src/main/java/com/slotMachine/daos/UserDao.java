package com.slotMachine.daos;

import com.slotMachine.models.UserDetails;

public interface UserDao {
	UserDetails getUserForUsername(String username);
	
}
