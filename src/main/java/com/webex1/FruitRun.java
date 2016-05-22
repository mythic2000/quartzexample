package com.webex1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class FruitRun {

    /**
     * @param args
     * @throws SecurityException 
     * @throws NoSuchFieldException 
     * @throws ClassNotFoundException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @throws ParseException 
     */
    public static void main(String[] args) throws NoSuchFieldException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, ParseException {
        
    	//FruitInfoUtil.getFruitInfo(Apple.class);
      /*  Annotation[] xx = Apple.class.getDeclaredField("appleName").getDeclaredAnnotations();
        
        FruitName fruitName = (FruitName) xx[0];
        
        System.out.println(fruitName.value());
        
      Apple abc= Apple.class.newInstance() ;
      
      Apple.class.cast(abc);
      
      Field[] cc = Apple.class.getDeclaredFields();*/
       
    	//FruitRun test = new FruitRun();
    	//test.testReflection();
    	
//		HashMap<String, String> dataMap = new HashMap<String, String>();
//		if(dataMap.get("ddd") == null) {
//			System.out.println("fdas");
//		}
		
//		String jsonString = "[{\"aa\":1}, {\"aa\":2}]";
//		JSONArray array = JSONArray.fromObject(jsonString);
//        


    	Map<String,String> map=new HashMap<String,String>();    
    	map.put("username", "qq");    
    	map.put("passWord", "123");    
    	map.put("userID", "1");    
    	map.put("email", "qq@qq.com");  
    	
    	Iterator it=map.entrySet().iterator();           
    	System.out.println( map.entrySet().size());    
    	String key;           
    	String value;    
    	while(it.hasNext()){    
    	        Map.Entry entry = (Map.Entry)it.next();           
    	        key=entry.getKey().toString();           
    	        value=entry.getValue().toString();           
    	        System.out.println(key+"===="+value);                     
    	}      
  
    }
    
    
    public void testReflection() throws IllegalArgumentException, IllegalAccessException {
    	 Apple apple = new Apple();
    	 Class clazz = apple.getClass();
    	Field[] flds = clazz.getDeclaredFields(); 
    	 if ( flds != null )  
    	    {  
    	        for ( int i = 0; i < flds.length; i++ )  
    	        {  
    	        	Annotation[] xx = flds[i].getDeclaredAnnotations();
    	            System.out.println(flds[i].getName() + " - " + flds[i].get(apple));  
    	            //xx[i].
    	        }  
    	    }  
    	System.out.println(flds.length);
    }

}