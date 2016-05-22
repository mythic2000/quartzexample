package com.webex1;


import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Json2Object {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		
		String jsonStirng = "{\"phonetype\":\"N95\",\"cat\":\"WP\"}";
		JSONObject json = JSONObject.fromObject(jsonStirng);
		
		System.out.println(json.getString("cat"));
		


		ObjectMapper mapper = new ObjectMapper();
		Object beanxxx =  mapper.readValue(json.toString(), BeanJson.class);
		
		
		
		//BeanJson bean = (BeanJson)JSONObject.toBean(json,BeanJson.class);
		
		System.out.println(BeanJson.class.cast(beanxxx).phone);
	}

}

class BeanJson {
	@JsonProperty("phonetype")
	public String phone;
	
	@JsonProperty("cat")
	public String catcat;

//	public String getPhone() {
//		return phone;
//	}
//
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//
//	public String getCatcat() {
//		return catcat;
//	}
//
//	public void setCatcat(String catcat) {
//		this.catcat = catcat;
//	}
	
}
