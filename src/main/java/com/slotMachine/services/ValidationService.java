package com.slotMachine.services;

import java.security.NoSuchAlgorithmException;

public interface ValidationService {

	String phraseHasher(String phrase) throws NoSuchAlgorithmException;
}
