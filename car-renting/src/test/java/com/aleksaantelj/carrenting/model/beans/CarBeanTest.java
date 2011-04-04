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
import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Aleksa Antelj
 */
public class CarBeanTest {

    private CarBean testCar;

    @BeforeMethod
    public void setUp() {
        testCar = new CarBean();
    }

    @Test
    public void testId() {
        assertNotNull(testCar.getId());
        int id = 21;
        testCar.setId(id);
        assertEquals(id, testCar.getId());
    }

    @Test
    public void testBrand() {
        assertNull(testCar.getBrand());
        String brand = "Hyundai";
        testCar.setBrand(brand);
        assertSame(brand, testCar.getBrand());
    }
    @Test
    public void testBuildYear() {
        assertNotNull(testCar.getBuildYear());
        int buildYear = 2009;
        testCar.setBuildYear(buildYear);
        assertEquals(buildYear, testCar.getBuildYear());
    }

    @Test
    public void testCategory() {
        assertNotNull(testCar.getCategory());
        char category = 'B';
        testCar.setCategory(category);
        assertEquals(category, testCar.getCategory());
    }

    @Test
    public void testDailyPrice() {
        assertNotNull(testCar.getDailyPrice());
        float dailyPrice = (float) 23.50;
        testCar.setDailyPrice(dailyPrice);
        assertEquals(dailyPrice, testCar.getDailyPrice());
    }

    @Test
    public void testModel() {
        assertNull(testCar.getModel());
        String model = "i30";
        testCar.setModel(model);
        assertSame(model, testCar.getModel());
    }

    @Test
    public void testRegistrationNumber() {
        assertNull(testCar.getRegistrationNumber());
        String registrationNumber = "BG 172-23";
        testCar.setRegistrationNumber(registrationNumber);
        assertSame(registrationNumber, testCar.getRegistrationNumber());
    }

    @Test
    public void testCarRents() {
        assertNull(testCar.getCarRents());
        testCar.setCarRents(new LinkedList<Rent>());
        assertNotNull(testCar.getCarRents());
    }

}
