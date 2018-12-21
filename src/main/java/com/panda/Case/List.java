package com.panda.Case;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class List {
  @Test
  public void f() {
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("before");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("after");
  }

  @BeforeTest
  public void beforeTest() {
	
  }

  @AfterTest
  public void afterTest() {
  }

}
