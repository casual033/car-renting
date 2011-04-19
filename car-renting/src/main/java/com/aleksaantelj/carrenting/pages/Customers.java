/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.pages;

import com.aleksaantelj.carrenting.model.Customer;
import com.aleksaantelj.carrenting.model.User;
import com.aleksaantelj.carrenting.service.CustomerService;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Aleksa Antelj
 */
public class Customers {

    @SessionState
    @Property
    private User user;
    private boolean userExists;

    @Inject
    @Property
    private CustomerService customerService;

    @Property
    private Customer customer;

    Object onActivate() {
        if (userExists) {
            if(user.isEmployee())
                return null;
        }
        return Index.class;
    }

}
