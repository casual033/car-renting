package com.aleksaantelj.carrenting.test.selenium;

import org.apache.tapestry5.test.SeleniumTestCase;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteCarSeleniumTest extends SeleniumTestCase {
	
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
		assertTextPresent("Available cars");
		assertTextPresent("Yugo 45");
		assertTextPresent("BG 995-669");
		click("link=Yugo 45");
		waitForPageToLoad();
		assertTextPresent("Yugo 45");
		assertTextPresent("BG 995-669");
		click("link=Update car details");
		waitForPageToLoad();
		assertTextPresent("Update car details");
		check("//input[@name='submit' and @value='Delete']");
  }
	
	@Test(dependsOnMethods="checkPageLoad")
	public void deleteCar() {
		openBaseURL();
		waitForPageToLoad();
		click("link=Yugo 45");
		waitForPageToLoad();
		click("link=Update car details");
		waitForPageToLoad();
		click("//input[@name='submit' and @value='Delete']");
		waitForPageToLoad();
		assertTextPresent("Available cars");
		assertFalse(isTextPresent("BG 995-669"));
	}
	
	
}
