/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.service.impl;

import com.aleksaantelj.carrenting.model.Car;
import com.aleksaantelj.carrenting.model.Rent;
import com.aleksaantelj.carrenting.model.beans.CustomerBean;
import com.aleksaantelj.carrenting.model.beans.RentBean;
import com.aleksaantelj.carrenting.model.beans.CarBean;
import com.aleksaantelj.carrenting.model.beans.UserBean;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import static org.testng.AssertJUnit.assertNull;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.Test;
/**
 *
 * @author Aleksa Antelj
 */
public class CarServiceDAOTest {

    AnnotationConfiguration config = new AnnotationConfiguration();
    private CarServiceDAO testCarDAO;
    private Car car;
    Session session;

    public CarServiceDAOTest() {
        testCarDAO = new CarServiceDAO();

        config.configure("hibernate.cfg.test.xml");
        config.addAnnotatedClass(UserBean.class);
        config.addAnnotatedClass(CustomerBean.class);
        config.addAnnotatedClass(RentBean.class);
        config.addAnnotatedClass(CarBean.class);

        SessionFactory factory = config.buildSessionFactory();
        session = factory.getCurrentSession();

        testCarDAO.setSessionFactory(factory);

        car = new CarBean();
        car.setBrand("Toyota");
        car.setBuildYear(2008);
        car.setCategory('B');
        car.setDailyPrice((float) 1900);
        car.setModel("Auris");
        car.setRegistrationNumber("BG 768-099");
        car.setCarRents(new LinkedList<Rent>());

        session.beginTransaction();
    }


    @Test
    public void testSaveCar() {
        assertNotNull(car);
        Car savedCar = testCarDAO.saveCar(car);
        assertEquals(car.getRegistrationNumber(), savedCar.getRegistrationNumber());
    }

    @Test(dependsOnMethods="testGetCar")
    public void testUpdateCar() {
        assertNotNull(car);
        car.setBrand("updateBrand");
        car.setModel("updateModel");
        car.setDailyPrice((float) 1980);
        testCarDAO.updateCar(car);
        Car updatedCar = testCarDAO.getCar(car.getId());
        assertEquals(car.getBrand(), updatedCar.getBrand());
        assertEquals(car.getModel(), updatedCar.getModel());
        assertEquals(car.getDailyPrice(), updatedCar.getDailyPrice());
    }

    @Test(dependsOnMethods="testSaveCar")
    public void testGetCar() {
        assertNotNull(car);
        car = testCarDAO.saveCar(car);
        Car fetchedCar = testCarDAO.getCar(car.getId());
        assertEquals(car.getBrand(), fetchedCar.getBrand());
        assertEquals(car.getModel(), fetchedCar.getModel());
        assertEquals(car.getDailyPrice(), fetchedCar.getDailyPrice());
        assertEquals(car.getBuildYear(), fetchedCar.getBuildYear());
        assertEquals(car.getRegistrationNumber(), fetchedCar.getRegistrationNumber());
    }

    @Test(dependsOnMethods="testUpdateCar")
    public void testDeleteCar() {
        car = testCarDAO.saveCar(car);
        assertNotNull(car);
        testCarDAO.deleteCar(car);
        Car fetchedCar = testCarDAO.getCar(car.getId());
        assertNull(fetchedCar);
    }

    @Test
    public void testGetAllCars() {
        List<Car> carList = testCarDAO.getAllCars();
        for (Iterator<Car> it = carList.iterator(); it.hasNext();) {
            Car car = it.next();
            assertNotNull(car);
        }
    }


}
