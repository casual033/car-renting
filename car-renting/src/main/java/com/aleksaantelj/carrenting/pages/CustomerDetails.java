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
public class CustomerDetails {

    @SessionState
    private User user;
    @Property
    private boolean userExists;

    @SessionState
    @Property
    private Customer customer;
    @Property
    private boolean customerExists;

    @Property
    private Customer currentCustomer;

    @Inject
    private CustomerService customerService;

    public Object onActivate(int id) {
        if(userExists) {
            if(user.isEmployee()) {
                currentCustomer = customerService.getCustomer(id);
            }
            else if(customerExists) {
                currentCustomer = customer;
            }
            return null;
        }
        return Index.class;
    }

    int onPassivate() {
        return currentCustomer.getId();
    }

}
