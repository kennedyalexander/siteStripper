package com.slotMachine.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.util.StringUtils;

import com.slotMachine.models.RollerState;
import com.slotMachine.models.WinStatus;

public class Spin implements Serializable {
	
	private List<RollerState> rollers;
	private WinStatus winStatus;
	
	public Spin(){
		rollers = new ArrayList<>(3);
		this.rollers.add(RollerState.APPLE);
		this.rollers.add(RollerState.BANANA);
		this.rollers.add(RollerState.CITRUS);
		this.winStatus = WinStatus.LOSE;
	}
	
	public Spin(List<RollerState> newRoll, WinStatus winStatus){
		this.rollers = newRoll;
		this.winStatus = winStatus;
	}
	
	public Spin(String stringifiedRollers, String winStatus){
		this.rollers = unStringifyRollers(stringifiedRollers);
		this.winStatus = stringToWin(winStatus);
	}

	/**
	 * @return the roller
	 */
	public List<RollerState> getRoller() {
		return rollers;
	}

	/**
	 * @return the winStatus
	 */
	public WinStatus getWinStatus() {
		return winStatus;
	}
	
	public String stringifyRollers(){
		String stringifiedRollers = "";
		int i = 0;
		for(RollerState roll : rollers){
			stringifiedRollers += roll.name().substring(0, 1);
			if(i < rollers.size()){
				stringifiedRollers += ".";
			}
		}
		return stringifiedRollers;
	}
	
	private List<RollerState> unStringifyRollers(String parseMe){
		List<RollerState> myRolls = new ArrayList<RollerState>();
		String[] parseingStrings = parseMe.split(".");
		for(String a : parseingStrings){
			switch(a) {
			case "AP" : myRolls.add(RollerState.APPLE);			
			break;
			case "BA" : myRolls.add(RollerState.BANANA);
			break;
			case "CI" : myRolls.add(RollerState.CITRUS);
			break;
			}
		}
		return myRolls;
	}
	
	private WinStatus stringToWin(String win){
		if (win.equals("WIN")){
			return WinStatus.WIN;
		} else {
			return WinStatus.LOSE;
		}
		}

}
