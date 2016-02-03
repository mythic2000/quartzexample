package com.webex;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml"})
public class TestHelloJob {
	private static Logger logger = LoggerFactory.getLogger(TestHelloJob.class);
	@Test
	public void testEmsPost() {
		logger.info("test");
		try {
			String userPass = "fraudbts"+":" + "JnVxRXp5d1E2s";
			String asB64 = Base64.getEncoder()
					.encodeToString(userPass.getBytes("utf-8"));
			logger.info("xxx:" + asB64);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
