package com.slotMachine.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slotMachine.models.RollerState;
import com.slotMachine.models.Spin;
import com.slotMachine.models.UserPlay;
import com.slotMachine.models.UserRequest;
import com.slotMachine.models.WinStatus;

@Service
public class RollServiceImpl implements RollService {

	@Autowired
	DataAccessServiceImpl dataAccessServiceImpl;

	@Override
	public UserPlay newRoll(UserRequest userRequest) {
		// TODO Auto-generated method stub
		Spin currentRoll = doRoll();
		// do spin
		// write spin to db with user who requested it
		UserPlay newPlay = new UserPlay(currentRoll, userRequest);
		dataAccessServiceImpl.logRoll(newPlay);
		return newPlay;
	}

	@Override
	public UserPlay newBetRoll(UserRequest userRequest, Integer bet) {
		return null;
	}

	// Make it simpler to know if its a win or loose rather then calculating
	// every time.
	public Spin checkRoll(List<RollerState> freshRolls) {
		// if(freshRolls.get(0).equals(freshRolls.get(1)) &&
		// freshRolls.get(1).equals(freshRolls.get(2))){
		// return new Spin(freshRolls, WinStatus.WIN);
		// } else {
		// return new Spin(freshRolls, WinStatus.LOOSE);
		// }
		// count each one if total is the same as .size
		HashMap<RollerState, String> map = new HashMap<RollerState, String>();
		for (int index = 0; index < freshRolls.size(); index++) {
			map.put(freshRolls.get(index), "SampleValue");
		}
		if (map.size() == 1) {
			return new Spin(freshRolls, WinStatus.WIN);
		} else {
			return new Spin(freshRolls, WinStatus.LOOSE);
		}
	}

	private Spin doRoll() {
		List<RollerState> freshRolls = new ArrayList<RollerState>();
		for (int i = 0; i < 3; i++) {
			freshRolls.add(rollReturnResult(Math.random()));
		}
		return checkRoll(freshRolls);
	}

	private Spin doRoll(int numberOfWheels) {
		List<RollerState> freshRolls = new ArrayList<RollerState>();
		for (int i = 0; i < numberOfWheels; i++) {
			freshRolls.add(rollReturnResult(Math.random()));
		}
		return checkRoll(freshRolls);
	}

	private RollerState rollReturnResult(double result) {
		if (result <= 0.35) {
			return RollerState.APPLE;
		} else if (result <= 0.65) {
			return RollerState.BANANA;
		} else {
			return RollerState.CITRUS;
		}
	}

	// planning to add value of your bet influencing the outcome
	private double convertToInfluencer(Integer Bet) {
		int length = String.valueOf(Bet).length();
		double bet = (1 - 1 / Bet);
		return bet;
	}

	// For adding betting
	private Spin doRoll(Integer bet) {
		return null;
	}

}
