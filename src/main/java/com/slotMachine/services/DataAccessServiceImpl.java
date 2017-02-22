package com.slotMachine.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slotMachine.daos.RollLogDaoImpl;
import com.slotMachine.models.UserDetails;
import com.slotMachine.models.UserPlay;

@Service
public class DataAccessServiceImpl implements DataAccessService {

	@Autowired
	RollLogDaoImpl rollLogDaoImpl;
	@Override
	public void logRoll(UserPlay spin) {
		rollLogDaoImpl.AddSpin(spin);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUser(UserDetails userDetails) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserDetails getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserPlay> getPlaysForUser(String username) {
		username = "oranges";
		List<UserPlay> getSpinsForUser = rollLogDaoImpl.GetSpinsForUser(username);
		return getSpinsForUser;
	}

}
