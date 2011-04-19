/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.pages;

import com.aleksaantelj.carrenting.model.Car;
import com.aleksaantelj.carrenting.model.User;
import com.aleksaantelj.carrenting.model.beans.CarBean;
import com.aleksaantelj.carrenting.service.CarService;
import org.apache.tapestry5.ValidationException;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Aleksa Antelj
 */
public class AddCar {

    @SessionState
    @Property
    private User user;
    private boolean userExists;

    @Property
    @Persist
    private Car car;

    @Inject
    private CarService carService;

    @Component
    private Form addCarForm;

    @Property
    private String brand;
    @Property
    private String model;
    @Property
    private String registrationNumber;
   // @Property
    //private char category;
    @Property
    private float dailyPrice;
    @Property
    private int buildYear;


    void onValidateFromAddCarForm() throws ValidationException {
        car = new CarBean();
        car.setBrand(brand);
        car.setBuildYear(buildYear);
        //car.setCategory(category);
        car.setDailyPrice(dailyPrice);
        car.setModel(model);
        car.setRegistrationNumber(registrationNumber);
        car = carService.saveCar(car);
        if(car == null) throw new ValidationException("Somethimg went wrong, try again!");
    }

    Object onSuccessFromAddCarForm() {
        return Index.class;
    }

    Object onActivate() {
        if (userExists) {
            if(user.isEmployee()) {
                return null;
            }
        }
        return Index.class;
    }

}

