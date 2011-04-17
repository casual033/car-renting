package com.aleksaantelj.carrenting.test.selenium;

import org.apache.tapestry5.test.SeleniumTestCase;
import org.testng.annotations.Test;

public class LoginTest extends SeleniumTestCase {
	
  @Test
  public void checkPageLoad() {
	  open(getBaseURL());
	  waitForPageToLoad();
	  check("username");
	  check("password");
	  check("submit");
  }
  
  @Test(dependsOnMethods="checkPageLoad")
  public void checkLoginEmpty() {
	  open(getBaseURL());
	  waitForPageToLoad();
	  click("submit");
	  //assertTextPresent("You must provide value for username");
	  //assertTextPresent("You must provide value for password");
	  
	  check("username");
	  check("password");
	  check("submit");
  }
  
  @Test(dependsOnMethods="checkLoginEmpty")
  public void checkLoginShort() {
	  open(getBaseURL());
	  waitForPageToLoad();
	  type("username","a");
	  type("password","a");
	  click("submit");
	  //assertTextPresent("You must provide at least 5 characters for username");
	  //assertTextPresent("You must provide at least 5 characters for password");
	  
	  check("username");
	  check("password");
	  check("submit");
  }
  
  @Test(dependsOnMethods="checkPageLoad")
  public void checkLoginWrongCredentials() {
	  open(getBaseURL());
	  waitForPageToLoad();
	  type("username","aaaaaa");
	  type("password","aaaaaa");
	  click("submit");
	  waitForPageToLoad();
	  check("username");
	  check("password");
	  check("submit");
  }
  
  @Test(dependsOnMethods="checkLoginWrongCredentials")
  public void checkLoginSuccess() {
	  open(getBaseURL());
	  waitForPageToLoad();
	  type("username","customer");
	  type("password","customer");
	  click("submit");
	  waitForPageToLoad();
	  assertTextPresent("Available cars");
  }
  
}
