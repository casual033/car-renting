/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.model.beans;

import com.aleksaantelj.carrenting.model.Car;
import com.aleksaantelj.carrenting.model.Rent;
import java.util.List;

/**
 *
 * @author Aleksa Antelj
 */
public class CarBean implements Car {

    private int id;
    private String registrationNumber;
    private String brand;
    private String model;
    private int buildYear;
    private char category;
    private float dailyPrice;
    private List<Rent> carRents;

    public List<Rent> getCarRents() {
        return carRents;
    }

    public void setCarRents(List<Rent> rents) {
        this.carRents = rents;
    }

    public float getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(float dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(int buildYear) {
        this.buildYear = buildYear;
    }

    public char getCategory() {
        return category;
    }

    public void setCategory(char category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

}
