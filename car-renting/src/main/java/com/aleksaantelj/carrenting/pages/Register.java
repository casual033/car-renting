/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.pages;

import com.aleksaantelj.carrenting.model.Customer;
import com.aleksaantelj.carrenting.model.User;
import com.aleksaantelj.carrenting.model.beans.CustomerBean;
import com.aleksaantelj.carrenting.service.CustomerService;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Aleksa Antelj
 */
public class Register {
    
    @SessionState
    private User user;
    private boolean userExists;

    @SessionState
    private Customer customer;
    private boolean customerExists;

    @Property
    private String username;
    @Property
    private String password;
    @Property
    private String firstName;
    @Property
    private String lastName;
    @Property
    private String jmbg;
    @Property
    private String address;
    @Property
    private String email;

    @Inject
    private CustomerService customerService;

    @Component
    private Form userRegisterForm;

    void onValidateFromUserRegisterForm() {
        Customer newCustomer = new CustomerBean();
        newCustomer.setEmail(email);
        newCustomer.setFirstName(firstName);
        newCustomer.setHomeAddress(address);
        newCustomer.setJmbg(jmbg);
        newCustomer.setLastName(lastName);
        newCustomer.setUsername(username);
        newCustomer.setPassword(password);
        newCustomer.setEmployee(false);
        try {
            newCustomer = customerService.saveCustomer(newCustomer);
            customer = newCustomer;
            user = newCustomer;
        } catch(Exception e){
            userRegisterForm.recordError("Username or Email address already in use.");
        }
    }

    Object onSuccessFromUserRegisterForm() {
        return Index.class;
    }

    Object onActivate() {
        if (userExists) {
            return Index.class;
        }
        return null;
    }
}
