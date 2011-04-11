/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.service.impl;

import static org.testng.AssertJUnit.assertNull;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertEquals;

import com.aleksaantelj.carrenting.model.User;
import com.aleksaantelj.carrenting.model.beans.UserBean;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Aleksa Antelj
 */
public class UserServiceDAOTest {

    AnnotationConfiguration config = new AnnotationConfiguration();
    private UserServiceDAO testUserDAO;
    private User user;
    Session session;

    public UserServiceDAOTest() {
        testUserDAO = new UserServiceDAO();

        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(UserBean.class);

        SessionFactory factory = config.buildSessionFactory();
        session = factory.getCurrentSession();

        testUserDAO.setSessionFactory(factory);

        user = new UserBean();
        user.setUsername("newUsername");
        user.setPassword("newPassword");
        user.setEmployee(true);

        session.beginTransaction();
    }

    @BeforeMethod
    public void setUp() {
        
    }

    @AfterMethod
    public void cleanUp() {

    }

    @Test
    public void testSaveUser() {
        assertNotNull(user);
        User savedUser = testUserDAO.saveUser(user);
        assertEquals(user.getUsername(), savedUser.getUsername());
    }

    @Test(dependsOnMethods="testGetUser")
    public void testUpdateUser() {
        assertNotNull(user);
        user.setUsername("updateUsername");
        user.setPassword("updatePassword");
        user.setEmployee(false);
        testUserDAO.updateUser(user);
        User updatedUser = testUserDAO.getUser(user.getId());
        assertEquals(user.getUsername(), updatedUser.getUsername());
        assertEquals(user.getPassword(), updatedUser.getPassword());
        assertEquals(user.isEmployee(), updatedUser.isEmployee());
    }

    @Test(dependsOnMethods="testSaveUser")
    public void testGetUser() {
        assertNotNull(user);
        user = testUserDAO.saveUser(user);
        User fetchedUser = testUserDAO.getUser(user.getId());
        assertEquals(user.getUsername(), fetchedUser.getUsername());
        assertEquals(user.getPassword(), fetchedUser.getPassword());
        assertEquals(user.isEmployee(), fetchedUser.isEmployee());
    }

    @Test(dependsOnMethods="testAuthenticateUser")
    public void testDeleteUser() {
        user = testUserDAO.saveUser(user);
        assertNotNull(user);
        testUserDAO.deleteUser(user);
        User fetchedUser = testUserDAO.authenticateUser(user);
        assertNull(fetchedUser);
    }

    @Test(dependsOnMethods="testUpdateUser")
    public void testAuthenticateUser() {
        User loginUser = new UserBean();
        loginUser.setUsername("a");
        loginUser.setPassword("a");
        loginUser = testUserDAO.authenticateUser(loginUser);
        assertNull(loginUser);
        loginUser = testUserDAO.authenticateUser(user);
        assertNotNull(loginUser);
    }

    @Test
    public void testGetAllUsers() {
        List<User> userList = testUserDAO.getAllUsers();
        for (Iterator<User> it = userList.iterator(); it.hasNext();) {
            User user = it.next();
            assertNotNull(user);
        }
    }

}
