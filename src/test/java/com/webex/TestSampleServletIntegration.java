package com.webex;


import org.apache.cactus.ServletTestCase; 
import org.apache.cactus.WebRequest;
import org.junit.Test;


public class TestSampleServletIntegration extends ServletTestCase {
	private SampleServlet servlet;

	protected void setUp() {
		//servlet = new SampleServlet();
	}

//	public void testIsAuthenticatedAuthenticated() {
//		session.setAttribute("authenticated", "true");
//		assertTrue(servlet.isAuthenticated(request));
//	}
//
//	public void testIsAuthenticatedNotAuthenticated() {
//		assertFalse(servlet.isAuthenticated(request));
//	}

	public void beginIsAuthenticatedNoSession(WebRequest request) {
		//request.setAutomaticSession(false);
	}

	@Test
	public void testIsAuthenticatedNoSession() {
		String temp = "aaa,bbb";
		if(temp.contains(",")) {
			//String conid = temp.split(",");
			System.out.println(temp.split(",")[0]);
		}
	}
}
