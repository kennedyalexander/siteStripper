package com.siteStripper.controllers;

import com.siteStripper.services.HttpRequest;
import com.siteStripper.services.SiteStripperService;
import com.siteStripper.services.SiteStripperServiceImpl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class SiteController {
	
	@Autowired
	SiteStripperService siteStripperService;
	@Autowired
	SiteStripperServiceImpl dataAccessService;
	@Autowired
	HttpRequest httpRequest;
	
	@RequestMapping(value = "/parseMe", method = RequestMethod.GET)
	public @ResponseBody String createUser(@RequestParam(value = "url") String url) throws IOException{
		//take string
		//go to url
		//get the page and pass to the stripper
		//xpath of headers that matter
		String hello = siteStripperService.findContent(url);
//		String hello = httpRequest.getRequest(url);
		
		return hello;
	}

}
