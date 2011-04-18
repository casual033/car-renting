/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.pages;

import com.aleksaantelj.carrenting.model.Car;
import com.aleksaantelj.carrenting.model.Customer;
import com.aleksaantelj.carrenting.model.Rent;
import com.aleksaantelj.carrenting.model.User;
import com.aleksaantelj.carrenting.model.beans.RentBean;
import com.aleksaantelj.carrenting.service.CarService;
import com.aleksaantelj.carrenting.service.RentService;
import java.util.Date;
import org.apache.tapestry5.ValidationException;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Aleksa Antelj
 */
public class RentACar {

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
    @Inject
    private RentService rentService;

    @Property
    private Date issueDate;
    @Property
    private Date returnDate;

    @Component
    private Form rentACarForm;

    @Property
    private Rent rent;

    void onValidateFromRentACarForm() throws ValidationException {
        rent = new RentBean();
        rent.setCar(car);
        rent.setCustomer(customer);
        rent.setIssueDate(issueDate);
        rent.setReturnDate(returnDate);
        rent.setReturned(false);
        rent = rentService.saveRent(rent);
    }

    Object onSuccesFromRentACarForm() {
        return Index.class;
    }

    public Object onActivate(int id) {
        if(customerExists) {
            car = carService.getCar(id);
            return null;
        }
        return Index.class;
    }

    int onPassivate() {
        return car.getId();
    }

}
