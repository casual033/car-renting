/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.model.beans;

import com.aleksaantelj.carrenting.model.Car;
import com.aleksaantelj.carrenting.model.Rent;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Aleksa Antelj
 */
@Entity
@Table(name="Car")
public class CarBean implements Car, Serializable {

    private int id;
    private String registrationNumber;
    private String brand;
    private String model;
    private int buildYear;
    private char category;
    private float dailyPrice;
    private List<Rent> carRents;

    @OneToMany(targetEntity=RentBean.class,mappedBy="car",cascade=CascadeType.ALL,
                    fetch=FetchType.LAZY)
    public List<Rent> getCarRents() {
        return carRents;
    }

    public void setCarRents(List<Rent> rents) {
        this.carRents = rents;
    }

    @Column(precision=10,scale=2)
    public float getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(float dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    @Column(length=100)
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

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(length=100)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(length=20)
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

}
