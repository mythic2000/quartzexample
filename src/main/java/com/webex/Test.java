package com.webex;

import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
	private static Logger logger = LoggerFactory.getLogger(Test.class);
	public static void main(String[] args) {
		URL url = Test.class.getClassLoader().getResource("log4j2.xml");
		logger.info(url.getPath());
		// TODO Auto-generated method stub
		logger.info("abcd");
		System.out.println("xxxx");
		int a = 0;
		if(a == 0) {
			System.out.println("1");
			
			System.out.println("2");
		}
	}

}
