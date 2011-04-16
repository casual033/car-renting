package com.aleksaantelj.carrenting.pages;

import com.aleksaantelj.carrenting.model.Car;
import com.aleksaantelj.carrenting.model.Customer;
import com.aleksaantelj.carrenting.model.User;
import com.aleksaantelj.carrenting.service.CarService;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 * Start page of application car-renting.
 */
public class Index
{

    @SessionState
    private User user;
    private boolean userExists;

    @SessionState
    private Customer customer;
    private boolean customerExists;

    @Inject
    @Property
    private CarService carService;

    @Property
    private Car car;
    
    

    Object onActivate() {
        if (userExists) {
            return null;
        }
        return Login.class;
    }
}
