/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.model.beans;

import java.util.Date;
import static org.testng.AssertJUnit.assertNull;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Aleksa Antelj
 */
public class RentBeanTest {

    private RentBean testRent;

    @BeforeMethod
    public void setUp() {
        testRent = new RentBean();
    }

    @Test
    public void testCustomer() {
        assertNull(testRent.getCustomer());
        testRent.setCustomer(new CustomerBean());
        assertNotNull(testRent.getCustomer());
    }

    @Test
    public void testCar() {
        assertNull(testRent.getCar());
        testRent.setCar(new CarBean());
        assertNotNull(testRent.getCar());
    }

    @Test
    public void testIssueDate() {
        assertNull(testRent.getIssueDate());
        Date issueDate = new Date();
        testRent.setIssueDate(issueDate);
        assertEquals(issueDate, testRent.getIssueDate());
    }

    @Test
    public void testReturnDate() {
        assertNull(testRent.getReturnDate());
        Date returnDate = new Date();
        testRent.setReturnDate(returnDate);
        assertEquals(returnDate, testRent.getReturnDate());
    }

}
