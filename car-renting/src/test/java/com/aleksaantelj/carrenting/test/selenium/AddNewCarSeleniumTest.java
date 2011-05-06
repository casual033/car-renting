package com.aleksaantelj.carrenting.test.selenium;

import org.apache.tapestry5.test.SeleniumTestCase;
import org.springframework.context.annotation.DependsOn;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AddNewCarSeleniumTest extends SeleniumTestCase{
	
	@BeforeClass
	  public void clearCookies() {
		  deleteAllVisibleCookies();
	  }
  
	@Test
  public void checkPageLoad() {
		openBaseURL();
		type("username","employee");
		type("password","employee");
		click("submit");
		waitForPageToLoad();
		assertTextPresent("Add new car");
		click("link=Add new car");
		waitForPageToLoad();
		assertTextPresent("Add new car");
		check("model");
		check("brand");
		check("dailyPrice");
		check("buildYear");
		check("registration");
		check("submit");
  }
	
	@Test(dependsOnMethods="checkPageLoad")
	  public void checkEmptyFields() {
			openBaseURL();
			waitForPageToLoad();
			click("link=Add new car");
			waitForPageToLoad();
			type("model","");
			type("brand","");
			type("dailyPrice","");
			type("buildYear","");
			type("registration","");
			click("submit");
			assertTextPresent("Add new car");
	  }
	
	@Test(dependsOnMethods="checkPageLoad")
	  public void checkInvalidValues() {
			openBaseURL();
			
			waitForPageToLoad();
			click("link=Add new car");
			waitForPageToLoad();
			type("model","45");
			type("brand","Yugo");
			type("dailyPrice","1400Dinara");
			type("buildYear","1998E");
			type("registration","BG 988-996");
			click("submit");
			assertTextPresent("Add new car");
	  }
	
	
	@Test(dependsOnMethods="checkPageLoad")
	  public void checkValidData() {
			openBaseURL();
			
			waitForPageToLoad();
			click("link=Add new car");
			waitForPageToLoad();
			type("model","45");
			type("brand","Yugo");
			type("dailyPrice","1400");
			type("buildYear","1998");
			type("registration","BG 995-669");
			click("submit");
			waitForPageToLoad();
			assertTextPresent("Available cars");
			assertTextPresent("BG 995-669");
	  }
}
