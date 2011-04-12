/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.service.impl;

import com.aleksaantelj.carrenting.model.Customer;
import com.aleksaantelj.carrenting.model.Rent;
import com.aleksaantelj.carrenting.model.beans.CarBean;
import com.aleksaantelj.carrenting.model.beans.UserBean;
import com.aleksaantelj.carrenting.model.beans.RentBean;
import com.aleksaantelj.carrenting.model.beans.CustomerBean;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

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
public class CustomerServiceDAOTest {

    AnnotationConfiguration config = new AnnotationConfiguration();
    private CustomerServiceDAO testCustomerDAO;
    private Customer customer;
    Session session;

    public CustomerServiceDAOTest() {
        testCustomerDAO = new CustomerServiceDAO();

        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(CustomerBean.class);
        config.addAnnotatedClass(UserBean.class);
        config.addAnnotatedClass(RentBean.class);
        config.addAnnotatedClass(CarBean.class);

        SessionFactory factory = config.buildSessionFactory();
        session = factory.getCurrentSession();

        testCustomerDAO.setSessionFactory(factory);

        customer = new CustomerBean();
        customer.setUsername("customerUsername");
        customer.setPassword("customerPassword");
        customer.setEmployee(false);
        customer.setEmail("customerEmail");
        customer.setFirstName("customerFirstName");
        customer.setLastName("customerLastName");
        customer.setHomeAddress("customerAddress");
        customer.setJmbg("customerJMBG");
        customer.setCustomerRents(new LinkedList<Rent>());

        session.beginTransaction();
    }


    @Test
    public void testSaveCustomer() {
        assertNotNull(customer);
        Customer savedCustomer = testCustomerDAO.saveCustomer(customer);
        assertEquals(customer.getUsername(), savedCustomer.getUsername());
    }

    @Test(dependsOnMethods="testGetCustomer")
    public void testUpdateCustomer() {
        assertNotNull(customer);
        customer.setUsername("updateUsername");
        customer.setPassword("updatePassword");
        customer.setFirstName("updateFirstName");
        customer.setLastName("updateFirstName");
        testCustomerDAO.updateCustomer(customer);
        Customer updatedCustomer = testCustomerDAO.getCustomer(customer.getId());
        assertEquals(customer.getUsername(), updatedCustomer.getUsername());
        assertEquals(customer.getPassword(), updatedCustomer.getPassword());
        assertEquals(customer.getFirstName(), updatedCustomer.getFirstName());
        assertEquals(customer.getLastName(), updatedCustomer.getLastName());
    }

    @Test(dependsOnMethods="testSaveCustomer")
    public void testGetCustomer() {
        assertNotNull(customer);
        customer = testCustomerDAO.saveCustomer(customer);
        Customer fetchedCustomer = testCustomerDAO.getCustomer(customer.getId());
        assertEquals(customer.getUsername(), fetchedCustomer.getUsername());
        assertEquals(customer.getPassword(), fetchedCustomer.getPassword());
        assertEquals(customer.isEmployee(), fetchedCustomer.isEmployee());
        assertEquals(customer.getFirstName(), fetchedCustomer.getFirstName());
        assertEquals(customer.getLastName(), fetchedCustomer.getLastName());
    }

    @Test(dependsOnMethods="testUpdateCustomer")
    public void testDeleteCustomer() {
        customer = testCustomerDAO.saveCustomer(customer);
        assertNotNull(customer);
        testCustomerDAO.deleteCustomer(customer);
        Customer fetchedCustomer = testCustomerDAO.getCustomer(customer.getId());
        assertNull(fetchedCustomer);
    }

    @Test
    public void testGetAllCustomers() {
        List<Customer> customerList = testCustomerDAO.getAllCustomers();
        for (Iterator<Customer> it = customerList.iterator(); it.hasNext();) {
            Customer customer = it.next();
            assertNotNull(customer);
        }
    }


}
