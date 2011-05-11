package com.aleksaantelj.carrenting.test.selenium;

import org.apache.tapestry5.test.SeleniumTestCase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CarRentingSeleniumTest extends SeleniumTestCase {
	
	@BeforeClass
	  public void clearCookies() {
          deleteAllVisibleCookies();
	  }

    @Test
    public void checkPageLoad() {
    	openBaseURL();
        type("username","customer");
        type("password","customer");
        click("submit");
        waitForPageToLoad();
        assertTextPresent("Available cars");
    }
    
    @Test(dependsOnMethods="checkPageLoad")
    public void checkRentACarLoad() {
    	openBaseURL();
    	click("link=Honda Jazz");
    	waitForPageToLoad();
    	assertTextPresent("Rent this car");
    	click("link=Rent this car");
    	waitForPageToLoad();
    	assertTextPresent("Rent a car");
    	check("issueDate");
    	check("returnDate");
    	check("submit");
    }
    
    @Test(dependsOnMethods="checkPageLoad")
    public void checkRentACarEmpty() {
    	openBaseURL();
    	click("link=Honda Jazz");
    	waitForPageToLoad();
    	click("link=Rent this car");
    	waitForPageToLoad();
    	type("issueDate","");
    	type("returnDate","");
    	click("submit");
    	assertTextPresent("Rent a car");
    }
    
    @Test(dependsOnMethods={"checkPageLoad","checkRentACarEmpty"})
    public void checkRentACarValid() {
    	openBaseURL();
    	waitForPageToLoad();
    	click("link=Honda Jazz");
    	waitForPageToLoad();
    	click("link=Rent this car");
    	waitForPageToLoad();
    	type("issueDate","21/6/2011");
    	type("returnDate","23/6/2011");
    	click("submit");
    	waitForPageToLoad();
    	openBaseURL();
    	waitForPageToLoad();
    	click("link=Honda Jazz");
    	waitForPageToLoad();
    	assertTextPresent("This car is rent out!");
    }
    
    @Test(dependsOnMethods={"checkPageLoad","checkRentACarValid"})
    public void checkReturnCar() {
    	openBaseURL();
    	click("link=Logout");
    	waitForPageToLoad();
    	type("username","employee");
    	type("password","employee");
    	click("submit");
    	waitForPageToLoad();
    	click("link=Honda Jazz");
    	waitForPageToLoad();
    	assertTextPresent("This car is rent out!");
    	assertTextPresent("Car retruned");
    	click("link=Car retruned");
    	waitForPageToLoad();
    	click("link=Honda Jazz");
    	waitForPageToLoad();
    	assertTextPresent("This car is available..");
    }
}
