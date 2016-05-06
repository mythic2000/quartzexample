package com.webex;

import org.apache.commons.validator.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailValidat {
	private static Logger logger = LoggerFactory.getLogger(EmailValidat.class);
	public static void main(String[] args) {
		String email = "f@dd.omcccc";
		if (email == null || "".equals(email))
			//return false;
		
		email = email.trim();
		
		EmailValidator ev = EmailValidator.getInstance();
		boolean valid =  ev.isValid(email);
		logger.info("valid:" + valid);
	}
	
}
