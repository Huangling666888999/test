package com.panda.Case;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.panda.Commen.Initialize;
import com.panda.Commen.SystemUtils;
import com.panda.api.BaseAction;

import junit.framework.TestSuite;

public class Pagelist extends Initialize{
	public static WebElement tab;
	public static WebElement button;
  @BeforeClass
   public static void setup() throws InterruptedException{
	Map<String, String> id = SystemUtils.getPropertyMap("Config/IdManage.properties");
    Thread.sleep(9000);
    System.out.println("11111"+id.get("Tab"));
	//tab=BaseAction.findElement(Initialize.androiddriver, id.get("Tab"));
	//System.out.println("0000"+tab);
    WebElement button=Initialize.androiddriver.findElementById("android:id/btnIgnore");
    tab=Initialize.androiddriver.findElementById("android:id/img");
    System.out.println("2222"+tab);
    button.click();
  
}
 @Test
 public void test(){
	//BaseAction.click(Initialize.androiddriver, tab);
 }
	
}
