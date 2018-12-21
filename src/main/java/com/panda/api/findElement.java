package com.panda.api;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

public class findElement {
	public static void findElement(AppiumDriver driver,String type,String value){
		if(type.equals("id")){
			WebElement element=driver.findElementById(value);
		}else if(type.equals("name")){
			WebElement element=driver.findElementByName(value);
		}else if(type.equals("xpath")){
			WebElement element=driver.findElementByXPath(value);
		}
	}
}
