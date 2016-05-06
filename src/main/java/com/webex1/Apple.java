package com.webex1;

import com.webex1.FruitColor.Color;

public class Apple {
    
    @FruitName("Apple")
    @FruitColor(fruitColor=Color.RED)
    public String appleName = "abc";
    
   // @FruitColor(fruitColor=Color.RED)
    public String appleColor = "red";
    
    @FruitProvider(id=1,name="陕西红富士集团",address="陕西省西安市延安路89号红富士大厦")
    public String appleProvider = "hangzhou";
    
    public int number = 6;
    
    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }
    public String getAppleColor() {
        return appleColor;
    }
    
    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }
    public String getAppleName() {
        return appleName;
    }
    
    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }
    public String getAppleProvider() {
        return appleProvider;
    }
    
    public void displayName(){
        System.out.println("水果的名字是：苹果");
    }
}
