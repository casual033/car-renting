/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.pages;

import com.aleksaantelj.carrenting.model.Customer;
import com.aleksaantelj.carrenting.model.User;
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
public class UpdateCustomer {

    @SessionState
    private User user;

    @SessionState
    @Property
    private Customer customer;
    @Property
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
    private Form updateCustomerForm;
    @Component
    private Form deleteCustomerForm;

    void onValidateFromUpdateCustomerForm() {
        try {
            customerService.updateCustomer(customer);
        } catch(Exception e){
            updateCustomerForm.recordError("There were some errors, try again!");
        }
    }

    Object onSuccessFromUpdateCustomerForm() {
        return Index.class;
    }

    void onValidateFromDeleteCustomerForm() {
        try {
            customerService.deleteCustomer(customer);
            customer = null;
            user = null;
        } catch(Exception e){
            deleteCustomerForm.recordError("There were some errors, try again!");
        }
    }

    Object onSuccessFromDeleteCustomerForm() {
        return Index.class;
    }

    Object onActivate() {
        if (customerExists) {
            return null;
        }
        return Index.class;
    }
}
