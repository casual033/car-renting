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
    public void testUserId() {
        assertNotNull(testRent.getUserId());
        int userId = 31;
        testRent.setUserId(userId);
        assertEquals(userId, testRent.getUserId());
    }

    @Test
    public void testCarId() {
        assertNotNull(testRent.getCarId());
        int carId = 31;
        testRent.setCarId(carId);
        assertEquals(carId, testRent.getCarId());
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
