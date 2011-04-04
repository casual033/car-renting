/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.model.beans;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertNull;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertSame;
import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Aleksa Antelj
 */
public class UserBeanTest {

    private UserBean testUser;

    @BeforeMethod
    public void setUp() {
        testUser = new UserBean();
    }

    @Test
    public void testUsername() {
        assertNull(testUser.getUsername());
        String username = "chester_rush";
        testUser.setUsername(username);
        assertSame(username, testUser.getUsername());
    }

    @Test
    public void testPassword() {
        assertNull(testUser.getPassword());
        String password = "chester.123!";
        testUser.setPassword(password);
        assertSame(password, testUser.getPassword());
    }

    @Test
    public void testId() {
        assertNotNull(testUser.getId());
        int id = 11;
        testUser.setId(id);
        assertEquals(id, testUser.getId());
    }

    @Test
    public void testEmployee() {
        assertFalse(testUser.isEmployee());
        testUser.setEmployee(true);
        assertTrue(testUser.isEmployee());
    }

}
