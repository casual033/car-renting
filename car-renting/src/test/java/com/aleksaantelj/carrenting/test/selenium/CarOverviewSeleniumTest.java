package com.aleksaantelj.carrenting.test.selenium;

import org.apache.tapestry5.test.SeleniumTestCase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CarOverviewSeleniumTest extends SeleniumTestCase {
	
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
    }
    
    @Test(dependsOnMethods="checkPageLoad")
    public void checkCarList() {
    	openBaseURL();
    	assertTextPresent("Available cars");
    	assertTextPresent("Honda Jazz");
    	assertTextPresent("BG 708-988");
    }
    
    @Test(dependsOnMethods="checkPageLoad")
    public void checkCarDetails() {
    	openBaseURL();
    	click("link=Honda Jazz");
    	waitForPageToLoad();
    	assertTextPresent("Car Details");
    	assertTextPresent("Car: Honda Jazz ");
    	assertTextPresent("Build year: 2009 ");
    	assertTextPresent("Daily price: 1950.0 "); 
    	assertTextPresent("Registration: BG 708-988"); 
    	assertTextPresent("This car is available..");
    }
    
    @Test(dependsOnMethods="checkPageLoad")
    public void checkCarRentingHistory() {
    	openBaseURL();
    	click("link=Honda Jazz");
    	waitForPageToLoad();
    	assertTextPresent("Car rents");
    	assertTextPresent("User");
    	assertTextPresent("First name");
    	assertTextPresent("Last name");
    	assertTextPresent("Issue date");
    	assertTextPresent("Return date");
    	assertTextPresent("Returned");
    	assertTextPresent("customer");
    	assertTextPresent("cust name");
    	assertTextPresent("customer last name");
    	assertTextPresent("2011-04-20");
    	assertTextPresent("2011-04-21");
    	assertTextPresent("true");
    }
    
    @Test(dependsOnMethods="checkPageLoad")
    public void checkUpdateCarDetailsLoad() {
    	openBaseURL();
    	click("link=Honda Jazz");
    	waitForPageToLoad();
    	click("link=Update car details");
    	waitForPageToLoad();
    	check("brand");
    	check("model");
    	check("buildYear");
    	check("dailyPrice");
    	check("submit");
    	check("//input[@name='submit' and @value='Delete']");
    }
    
    @Test(dependsOnMethods="checkPageLoad")
    public void checkUpdateCarDetailsEmpty() {
    	openBaseURL();
    	click("link=Honda Jazz");
    	waitForPageToLoad();
    	click("link=Update car details");
    	waitForPageToLoad();
    	type("brand","");
    	type("model","");
    	type("buildYear","");
    	type("dailyPrice","");
    	click("submit");
    	assertTextPresent("Update car details");
    }
    
    @Test(dependsOnMethods="checkPageLoad")
    public void checkUpdateCarDetailsInvalid() {
    	openBaseURL();
    	click("link=Honda Jazz");
    	waitForPageToLoad();
    	click("link=Update car details");
    	waitForPageToLoad();
    	type("brand","Honda");
    	type("model","Jazz");
    	type("buildYear","19YEar");
    	type("dailyPrice","1900Din");
    	click("submit");
    	assertTextPresent("Update car details");
    }
    
    @Test(dependsOnMethods="checkPageLoad")
    public void checkUpdateCarDetailsValid() {
    	openBaseURL();
    	click("link=Honda Jazz");
    	waitForPageToLoad();
    	click("link=Update car details");
    	waitForPageToLoad();
    	type("brand","new brand");
    	type("model","new model");
    	type("buildYear","2000");
    	type("dailyPrice","1000");
    	click("submit");
    	waitForPageToLoad();
    	assertTextPresent("new brand");
    	click("link=new brand new model");
    	waitForPageToLoad();
    	assertTextPresent("2000");
    	assertTextPresent("1000");
    	
    	click("link=Update car details");
    	waitForPageToLoad();
    	type("brand","Honda");
    	type("model","Jazz");
    	type("buildYear","2009");
    	type("dailyPrice","1950");
    	click("submit");
    	waitForPageToLoad();
    }
}
