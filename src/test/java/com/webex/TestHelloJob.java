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
		String temp = "aaa,bbb";
		if(temp.contains(",")) {
			//String conid = temp.split(",");
			System.out.println(temp.split(",")[0]);
		}

	}
}
