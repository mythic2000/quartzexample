package com.webex1;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;


public class ValidateEmailExample {
	public static void main(String[] args) {
		  ValidateEmailExample example = new ValidateEmailExample();
		  String email = "email@xxxx.com";

		  boolean isValid = example.validateEmail(email);

		  example.printStatus(email, isValid);

		  email = "email.javacodegeks";

		  isValid = example.validateEmail(email);

		  example.printStatus(email, isValid);

		    }

		    private boolean validateEmail(String email) {

		  boolean isValid = false;

		  try {
		 
		//Create InternetAddress object and validated the email address.
		 
		InternetAddress internetAddress = new InternetAddress(email);
		 
		internetAddress.validate();
		 
		isValid = true;
		 
		  } catch (AddressException e) {
		 
		e.printStackTrace();
		 
		  }
		 
		  return isValid;
		    }
		 
		    private void printStatus(String email, boolean valid) {
		 
		  System.out.println(email + " is " + (valid ? "a" : "not a") +
		 
		    " valid email address");
		    }

}
