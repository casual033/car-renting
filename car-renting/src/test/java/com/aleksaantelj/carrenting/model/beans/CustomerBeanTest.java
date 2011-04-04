/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.model.beans;

import com.aleksaantelj.carrenting.model.Rent;
import java.util.LinkedList;
import static org.testng.AssertJUnit.assertNull;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertSame;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 *
 * @author Aleksa Antelj
 */
public class CustomerBeanTest {

    private CustomerBean testCustomer;

    @BeforeMethod
    public void setUp() {
        testCustomer = new CustomerBean();
    }

    @Test
    public void testFirstName() {
        assertNull(testCustomer.getFirstName());
        String firstName = "Chester";
        testCustomer.setFirstName(firstName);
        assertSame(firstName, testCustomer.getFirstName());
    }

    @Test
    public void testLastName() {
        assertNull(testCustomer.getLastName());
        String lastName = "Rush";
        testCustomer.setLastName(lastName);
        assertSame(lastName, testCustomer.getLastName());
    }
    @Test
    public void testHomeAddress() {
        assertNull(testCustomer.getHomeAddress());
        String homeAddress = "101 Leksington Street, New York, USA";
        testCustomer.setHomeAddress(homeAddress);
        assertSame(homeAddress, testCustomer.getHomeAddress());
    }
    @Test
    public void testEmail() {
        assertNull(testCustomer.getEmail());
        String email = "chester_rush@gmail.com";
        testCustomer.setEmail(email);
        assertSame(email, testCustomer.getEmail());
    }
    @Test
    public void testJmbg() {
        assertNull(testCustomer.getJmbg());
        String jmbg = "0102980710205";
        testCustomer.setJmbg(jmbg);
        assertSame(jmbg, testCustomer.getJmbg());
    }
    @Test
    public void testCustomerRents() {
        assertNull(testCustomer.getCustomerRents());
        testCustomer.setCustomerRents(new LinkedList<Rent>());
        assertNotNull(testCustomer.getCustomerRents());
    }

}
