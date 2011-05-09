package com.aleksaantelj.carrenting.test.selenium;

import org.apache.tapestry5.test.SeleniumTestCase;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginSeleniumTest extends SeleniumTestCase {
	
	@BeforeClass
	  public void clearCookies() {
		  deleteAllVisibleCookies();
	  }
	
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
  
  @Test(dependsOnMethods="checkLoginSuccess")
  public void checkLogOut() {
	  open(getBaseURL());
	  waitForPageToLoad();
	  assertTextPresent("Logout");
	  click("link=Logout");
	  waitForPageToLoad();
	  assertTextPresent("Login page");
	  check("username");
	  check("password");
	  check("submit");
  }
  
  
  
}
