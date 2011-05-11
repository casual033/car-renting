package com.aleksaantelj.carrenting.test.selenium;

import org.apache.tapestry5.test.SeleniumTestCase;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterSeleniumTest extends SeleniumTestCase {
	
	@BeforeClass
	  public void clearCookies() {
          deleteAllVisibleCookies();
	  }

    @Test
    public void checkPageLoad() {
        openBaseURL();
        assertTextPresent("Register");
        click("link=Register");
        waitForPageToLoad();
        assertTextPresent("Registration");
        check("username");
        check("password");
        check("firstName");
        check("lastName");
        check("email");
        check("address");
        check("jmbg");
        check("submit");
    }
    
    @Test(dependsOnMethods="checkPageLoad")
    public void checkEmpty() {
    	openBaseURL();
        click("link=Register");
        waitForPageToLoad();
        type("username","");
        type("password","");
        type("firstName","");
        type("lastName","");
        type("email","");
        type("address","");
        type("jmbg","");
        click("submit");
        assertTextPresent("Registration");
    }
    
    @Test(dependsOnMethods="checkPageLoad")
    public void checkShortUsername() {
    	openBaseURL();
        click("link=Register");
        waitForPageToLoad();
        type("username","user");
        type("password","password");
        type("firstName","firstName");
        type("lastName","lastName");
        type("email","email@user.com");
        type("address","address");
        type("jmbg","9592252");
        click("submit");
        assertTextPresent("Registration");
    }
    
    @Test(dependsOnMethods={"checkShortUsername","checkEmpty"})
    public void checkValidData() {
    	openBaseURL();
        click("link=Register");
        waitForPageToLoad();
        type("username","customerM");
        type("password","customerM");
        type("firstName","firstName");
        type("lastName","lastName");
        type("email","email@user.com");
        type("address","address");
        type("jmbg","9592252");
        click("submit");
        waitForPageToLoad();
        assertTextPresent("Available cars");
    }
    
    @Test(dependsOnMethods="checkValidData")
    public void checkNewLogin() {
    	openBaseURL();
        click("link=Logout");
        waitForPageToLoad();
        type("username","customerM");
        type("password","customerM");
        click("submit");
        waitForPageToLoad();
        assertTextPresent("Available cars");
    }
  
}
