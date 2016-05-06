package com.webex1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;

public class FruitRun {

    /**
     * @param args
     * @throws SecurityException 
     * @throws NoSuchFieldException 
     * @throws ClassNotFoundException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    public static void main(String[] args) throws NoSuchFieldException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        
    	//FruitInfoUtil.getFruitInfo(Apple.class);
      /*  Annotation[] xx = Apple.class.getDeclaredField("appleName").getDeclaredAnnotations();
        
        FruitName fruitName = (FruitName) xx[0];
        
        System.out.println(fruitName.value());
        
      Apple abc= Apple.class.newInstance() ;
      
      Apple.class.cast(abc);
      
      Field[] cc = Apple.class.getDeclaredFields();*/
       
    	//FruitRun test = new FruitRun();
    	//test.testReflection();
    	
		HashMap<String, String> dataMap = new HashMap<String, String>();
		if(dataMap.get("ddd") == null) {
			System.out.println("fdas");
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