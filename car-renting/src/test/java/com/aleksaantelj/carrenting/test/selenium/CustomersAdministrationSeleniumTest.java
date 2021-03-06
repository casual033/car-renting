package com.aleksaantelj.carrenting.test.selenium;

import org.apache.tapestry5.test.SeleniumTestCase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CustomersAdministrationSeleniumTest extends SeleniumTestCase {
	
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
    public void checkCustomersList() {
    	openBaseURL();
    	assertTextPresent("Customer list");
    	click("link=Customer list");
    	waitForPageToLoad();
    	assertTextPresent("Registered customers");
    	assertTextPresent("Dejan Petkovic");
    }
    
    @Test(dependsOnMethods="checkPageLoad")
    public void checkCustomerDetails() {
    	openBaseURL();
    	click("link=Customer list");
    	waitForPageToLoad();
    	click("link=Dejan Petkovic");
    	waitForPageToLoad();
    	assertTextPresent("Customer Details");
    	assertTextPresent("Customer: customer ");
    	assertTextPresent("First name Dejan ");
    	assertTextPresent("Last name: Petkovic ");
    	assertTextPresent("Email: reg@cust.com ");
    	assertTextPresent("JMBG: 1212121212 ");
    	assertTextPresent("Address: Partizanska 123 ");
    }
    
    @Test(dependsOnMethods="checkPageLoad")
    public void checkCustomerRents() {
    	openBaseURL();
    	click("link=Customer list");
    	waitForPageToLoad();
    	click("link=Dejan Petkovic");
    	waitForPageToLoad();
    	assertTextPresent("Customer rents");
    	assertTextPresent("Brand");
    	assertTextPresent("Model");
    	assertTextPresent("Registration");
    	assertTextPresent("Issue date");
    	assertTextPresent("Return date");
    	assertTextPresent("Returned");
    	assertTextPresent("Honda");
    	assertTextPresent("Jazz");
    	assertTextPresent("BG 708-988");
    	assertTextPresent("2011-04-20");
    	assertTextPresent("2011-04-21");
    	assertTextPresent("true");
    }
}
