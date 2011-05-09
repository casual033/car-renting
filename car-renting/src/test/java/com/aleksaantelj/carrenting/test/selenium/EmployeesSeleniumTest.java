package com.aleksaantelj.carrenting.test.selenium;

import org.apache.tapestry5.test.SeleniumTestCase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EmployeesSeleniumTest extends SeleniumTestCase {
	
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
	public void checkEmployeesLink() {
            openBaseURL();
            assertTextPresent("Employees list");
	}
	
	@Test(dependsOnMethods="checkPageLoad")
	public void checkEmployeesList() {
		openBaseURL();
		click("link=Employees list");
		waitForPageToLoad();
		assertTextPresent("Current employees");
		assertTextPresent("employee");
	}

	@Test(dependsOnMethods="checkPageLoad")
	public void checkAddEmployeeLink() {
		openBaseURL();
		assertTextPresent("Add employee");
	}

	@Test(dependsOnMethods="checkPageLoad")
	public void checkLoadAddEmployee() {
		openBaseURL();

		assertTextPresent("Add employee");
		click("link=Add employee");
		waitForPageToLoad();
		assertTextPresent("Add new employee");
		check("username");
		check("password");
		check("submit");
	}

	@Test(dependsOnMethods="checkLoadAddEmployee")
	public void checkAddEmployeeEmpty() {
		openBaseURL();
		click("link=Add employee");
                waitForPageToLoad();
		click("submit");
		assertTextPresent("Add new employee");
	}

	@Test(dependsOnMethods="checkLoadAddEmployee")
	public void checkAddEmployeeShort() {
		openBaseURL();
		click("link=Add employee");
		waitForPageToLoad();
		type("username","user");
		type("password","user");
		click("submit");
		assertTextPresent("Add new employee");

	}

	@Test(dependsOnMethods="checkLoadAddEmployee")
	public void checkAddEmployeeEmptyLong() {
		openBaseURL();
		click("link=Add employee");
		waitForPageToLoad();
		type("username","verylongusername");
		type("password","verylongpassword");
		click("submit");
		assertTextPresent("Add new employee");
	}

	@Test(dependsOnMethods="checkLoadAddEmployee")
	public void checkAddEmployeeExistingUsername() {
		openBaseURL();
		click("link=Add employee");
		waitForPageToLoad();
		type("username","employee");
		type("password","employee");
		click("submit");
		assertTextPresent("Add new employee");
	}

	@Test(dependsOnMethods="checkLoadAddEmployee")
	public void checkAddEmployeeValid() {
		openBaseURL();
		waitForPageToLoad();
		click("link=Add employee");
		waitForPageToLoad();
		type("username","validuser");
		type("password","validuser");
		click("submit");
		waitForPageToLoad();
		assertTextPresent("Current employees");
		assertTextPresent("validuser");
	}

	@Test(dependsOnMethods="checkAddEmployeeValid")
	public void checkDeleteEmployee() {
		openBaseURL();
		click("link=Employees list");
		waitForPageToLoad();
		click("link=Delete validuser");
		waitForPageToLoad();
		assertTextPresent("Current employees");
		assertFalse(isTextPresent("validuser"));
	}
}
