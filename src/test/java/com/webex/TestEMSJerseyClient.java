package com.webex;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml"})
public class TestEMSJerseyClient {
	private static Logger logger = LoggerFactory.getLogger(TestEMSJerseyClient.class);
	
	@Autowired
	private EMSJerseyClient emsJerseyClient;
	
	@Test
	public void testEmsPost() {
		emsJerseyClient.emsPost();
	}

}
