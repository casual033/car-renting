/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.pages;

import com.aleksaantelj.carrenting.model.Car;
import com.aleksaantelj.carrenting.model.Customer;
import com.aleksaantelj.carrenting.model.Rent;
import com.aleksaantelj.carrenting.model.User;
import com.aleksaantelj.carrenting.service.CarService;
import com.aleksaantelj.carrenting.service.RentService;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Aleksa Antelj
 */
public class CarDetails {

    @SessionState
    @Property
    private User user;
    @Property
    private boolean userExists;

    @SessionState
    private Customer customer;
    @Property
    private boolean customerExists;

    @Property
    private Car car;

    @Inject
    private CarService carService;

    @Property
    private Rent rent;

    @Inject
    @Property
    private RentService rentService;

    public void onActivate(int id) {
        car = carService.getCar(id);
    }

    int onPassivate() {
        return car.getId();
    }

}
