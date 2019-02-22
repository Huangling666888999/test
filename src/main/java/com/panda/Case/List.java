package com.panda.Case;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;

public class List {
	@DataProvider(name="datap")
	public Object[][] data(){
		return new Object[][]{{"1"},{"2"}};
	}
  @Test(dataProvider="datap")
  public void test(String name) {
	  System.out.println(name);
  }
  
  @AfterClass
  public void afterClass() {
	  System.out.println("afterclass");
  }

  @AfterTest
  public void afterTest() {
  System.out.println("aftertest");
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("beforeclass");
  }
@BeforeMethod
public void beforemethod() {
	System.out.println("beforemethod");
 }
  @BeforeTest
  public void beforeTest() {
	System.out.println("beforetest");
  }
@BeforeSuite
public void beforesuit() {
	System.out.println("beforesuit");
 }
@AfterMethod
public void aftermethod() {
	System.out.println("aftermethod");
 }
}
