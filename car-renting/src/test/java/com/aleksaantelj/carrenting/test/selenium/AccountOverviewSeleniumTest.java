package com.aleksaantelj.carrenting.test.selenium;

import org.apache.tapestry5.test.SeleniumTestCase;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AccountOverviewSeleniumTest extends SeleniumTestCase {
	
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
    public void checkMyDetails() {
    	openBaseURL();
    	assertTextPresent("My Profile");
    	click("link=My Profile");
    	waitForPageToLoad();
    	assertTextPresent("Customer Details");
    	assertTextPresent("customer");
    	assertTextPresent("Dejan");
    	assertTextPresent("Petkovic");
    	assertTextPresent("1212121212");
    }
    
    @Test(dependsOnMethods="checkPageLoad")
    public void checkMyRents() {
    	openBaseURL();
    	assertTextPresent("My Profile");
    	click("link=My Profile");
    	waitForPageToLoad();
    	assertTextPresent("Customer rents");
    	assertTextPresent("Brand");
    	assertTextPresent("Model");
    	assertTextPresent("Registration");
    	assertTextPresent("Issue date");
    	assertTextPresent("Return date");
    	assertTextPresent("Returned");
    }

    @Test(dependsOnMethods="checkMyDetails")
    public void checkUpdateProfileLoadPage() {
    	openBaseURL();
    	assertTextPresent("Update my details");
    	click("link=Update my details");
    	waitForPageToLoad();
    	check("username");
        check("password");
        check("firstName");
        check("lastName");
        check("email");
        check("address");
        check("jmbg");
        check("submit");
    }

    @Test(dependsOnMethods={"checkMyDetails"})
    public void checkUpdateProfile() {
    	openBaseURL();
    	click("link=Update my details");
    	waitForPageToLoad();
    	type("password","customer");
        type("firstName","new first name");
        type("lastName","new last name");
        type("email","new email");
        type("address","new address");
        type("jmbg","141414141414");
        click("submit");
        waitForPageToLoad();
        click("link=My Profile");
    	waitForPageToLoad();
    	assertTextPresent("new first name");
    	assertTextPresent("new last name");
    	assertTextPresent("new email");
    	assertTextPresent("141414141414");

    	click("link=Update my details");
    	waitForPageToLoad();
    	type("password","customer");
        type("firstName","Dejan");
        type("lastName","Petkovic");
        type("email","reg@cust.com");
        type("address","Partizanska 123");
        type("jmbg","1212121212");
        click("submit");
        waitForPageToLoad();
    }

    @Test(dependsOnMethods={"checkMyDetails","checkUpdateProfile"})
    public void checkUpdateProfileEmpty() {
    	openBaseURL();
    	click("link=Update my details");
    	waitForPageToLoad();
    	type("username","");
        type("password","");
        type("firstName","");
        type("lastName","");
        type("email","");
        type("address","");
        type("jmbg","");
        click("submit");
        assertTextPresent("Update account");
    }

    @Test(dependsOnMethods={"checkMyDetails","checkUpdateProfile"})
    public void checkUpdateProfileShortUsername() {
    	openBaseURL();
    	click("link=Update my details");
    	waitForPageToLoad();
    	type("username","user");
        type("password","password");
        type("firstName","firstName");
        type("lastName","lastName");
        type("email","email@user.com");
        type("address","address");
        type("jmbg","9592252");
        click("submit");
        assertTextPresent("Update account");
    }
}
