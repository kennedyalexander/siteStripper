package com.slotMachine.controllers;

import com.slotMachine.models.RollerState;
import com.slotMachine.models.Spin;
import com.slotMachine.models.UserPlay;
import com.slotMachine.models.UserRequest;
import com.slotMachine.services.DataAccessServiceImpl;
import com.slotMachine.services.RollServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class GameController {
	
	@Autowired
	RollServiceImpl rollingService;
	@Autowired
	DataAccessServiceImpl dataAccessService;
	
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public @ResponseBody String createUser(@RequestBody UserRequest request){
		return null;
	}

	@RequestMapping(value = "/roll", method = RequestMethod.POST)
	public @ResponseBody UserPlay newSpin(@RequestBody UserRequest request){
		return rollingService.newRoll(request);	
	}
	
	@RequestMapping(value = "/getRollsForUser", method = RequestMethod.POST)
	public @ResponseBody List<UserPlay> getRollsForUser(@RequestBody UserRequest request){
		return dataAccessService.getPlaysForUser(request.getUsername());
	}
}
