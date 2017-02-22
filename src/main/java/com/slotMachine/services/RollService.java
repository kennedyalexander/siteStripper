package com.slotMachine.services;

import java.util.List;

import com.slotMachine.models.RollerState;
import com.slotMachine.models.Spin;
import com.slotMachine.models.UserPlay;
import com.slotMachine.models.UserRequest;

public interface RollService {
	
	UserPlay newRoll(UserRequest userRequest);
	UserPlay newBetRoll(UserRequest userRequest, Integer bet);

}
