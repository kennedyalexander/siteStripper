package com.slotMachine.daos;

import java.util.List;

import com.slotMachine.models.Spin;
import com.slotMachine.models.UserPlay;

public interface RollLogDao {
	
	List<UserPlay> GetSpinsForUser(String username);
	UserPlay GetLastSpinForUser(String username);
	void AddSpin(UserPlay newSpin);
	List<UserPlay> GetWinningSpins();
	

}
