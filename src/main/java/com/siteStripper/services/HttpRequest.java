package com.siteStripper.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.stereotype.Service;

@Service
public class HttpRequest {

	
	public String getRequest(String myUrl) throws IOException{
		URL obj = new URL(myUrl);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		con.setRequestMethod("GET");
		String USER_AGENT = "Mozilla/5.0";
		con.setRequestProperty("User-Agent", USER_AGENT );
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		
		while((inputLine = in.readLine()) != null){
			response.append(inputLine);
		}
		in.close();
		return response.toString();
		
	}
}
