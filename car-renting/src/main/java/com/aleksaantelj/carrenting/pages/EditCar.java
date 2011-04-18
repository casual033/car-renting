/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.pages;

import com.aleksaantelj.carrenting.model.Car;
import com.aleksaantelj.carrenting.model.User;
import com.aleksaantelj.carrenting.service.CarService;
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
public class EditCar {

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
    private Form updateCarForm;

    void onValidateFromUpdateCarForm() {
        try {
            carService.updateCar(car);
        }
        catch(Exception e) {
            updateCarForm.recordError("Some error occured, try again!");
        }
    }

    Object onSuccessFromUpdateCarForm() {
        return Index.class;
    }

    Object onActivate(int id) {
        if (userExists) {
            if(user.isEmployee()) {
                car = carService.getCar(id);
                return null;
            }
        }
        return Index.class;
    }

}
