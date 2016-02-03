package com.webex;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Service
public class EMSJerseyClient {
	
	private static Logger logger = LoggerFactory.getLogger(EMSJerseyClient.class);

	public void emsPost() {
		try {

			Client client = Client.create();

			WebResource webResource = client
			   .resource("http://mtbt1ims001.webex.com/api/internal/handler_v1");

			String input = "{\"eventName\": \"EventName\",  \"ts\": 123456789,  \"level\": 5,"+  
            "\"message\": \"xyz module operationally down!\",  \"eventSource\" : {  "+
        "\"hostname\" : \"zsj1tlm001.webex.com.com\",  \"hostAddress\"   : \"192.168.1.10\" },"+  
        "\"dataParam\"  : {  \"deploymentName\": \"SJC02\", "+ 
        "\"moreDetails\"   : \"Additional json payload\",   \"groupID\" : 3 }  }  ";

			String asB64 = "";
			String userPass = "fraudbts"+":" + "JnVxRXp5d1E2s";
			try {
				
				asB64 = Base64.getEncoder()
						.encodeToString(userPass.getBytes("utf-8"));
				logger.info("xxx:" + asB64);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			asB64 = "Basic " + asB64.trim();
			
			ClientResponse response = webResource.type("application/json")
					.header("Authorization", asB64)
					.header("Webex-SOC-Token", "l3BAMwa4ZYHUA-jKzejcb0GG6ho-JnVxRXp5d1E2s")
			   .post(ClientResponse.class, input);

			/*if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
				     + response.getStatus());
			}*/

			System.out.println("Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);

		  } catch (Exception e) {

			e.printStackTrace();

		  }
	}
}
