/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.pages;

import com.aleksaantelj.carrenting.model.User;
import com.aleksaantelj.carrenting.service.CarService;
import com.aleksaantelj.carrenting.service.RentService;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Aleksa Antelj
 */
public class ReturnCar {
    
    @SessionState
    private User user;
    private boolean userExists;
    
    @Inject
    private RentService rentService;
    
    @Inject
    private CarService carService;

    Object onActivate(int carId) {
        if (userExists) {
            if(user.isEmployee())
                rentService.returnCar(carService.getCar(carId));
        }
        return Index.class;
    }

}
