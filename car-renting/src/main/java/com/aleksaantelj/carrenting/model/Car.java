/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.model;

import java.util.List;

/**
 *
 * @author Aleksa Antelj
 */
public interface Car {

    String getBrand();

    int getBuildYear();

    char getCategory();

    int getId();

    String getModel();

    String getRegistrationNumber();

    float getDailyPrice();

    public List<Rent> getCarRents();

    public void setCarRents(List<Rent> rents);

    void setDailyPrice(float dailyPrice);

    void setBrand(String brand);

    void setBuildYear(int buildYear);

    void setCategory(char category);

    void setId(int id);

    void setModel(String model);

    void setRegistrationNumber(String registrationNumber);

}
