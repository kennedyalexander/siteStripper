package com.slotMachine.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

@Service
public class ValidationServiceImpl implements ValidationService {

	  private static String PASSWORD_SALT = "Salting"; //inventive Hash, Would prefer to us something a bit more secret and complex but this will work


	public String phraseHasher(String phrase) throws NoSuchAlgorithmException {
		phrase += PASSWORD_SALT; 
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(phrase.getBytes());

		byte byteData[] = md.digest();

		// convert the byte to hex format method 1
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 50).substring(1));
		}

		return sb.toString();
	}

}
