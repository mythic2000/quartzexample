package com.webex;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.cactus.ServletTestCase; 
import org.apache.cactus.WebRequest;

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
		String xx = String.valueOf(1234L);
		logger.info(xx);
		
		String tt = "abcdef";
		String aa = "cd";
		
		if(tt.contains(aa)){
			logger.info("fadfsas"); 
		}

	}
}
