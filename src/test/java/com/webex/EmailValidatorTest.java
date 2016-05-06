package com.webex;

import org.apache.commons.validator.EmailValidator;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailValidatorTest {
	private static Logger logger = LoggerFactory.getLogger(EmailValidatorTest.class);
	
	@Test
	public void isValidMail() {
		String email = "nmtz111@gmail.com";
		if (email == null || "".equals(email))
			//return false;
		
		email = email.trim();
		
		EmailValidator ev = EmailValidator.getInstance();
		boolean valid =  ev.isValid(email);
		logger.info("valid:" + valid);
		
	}
}
