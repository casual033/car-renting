/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.pages;

import com.aleksaantelj.carrenting.model.User;
import com.aleksaantelj.carrenting.model.beans.UserBean;
import com.aleksaantelj.carrenting.service.UserService;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Aleksa Antelj
 */
public class AddEmployee {

    @SessionState
    @Property
    private User user;
    private boolean userExists;

    @Property
    private String username;
    @Property
    private String password;

    @Inject
    private UserService userService;

    @Component
    private Form addEmployeeForm;

    void onValidateFromAddEmployeeForm() {
        User newEmployee = new UserBean();
        newEmployee.setUsername(username);
        newEmployee.setPassword(password);
        newEmployee.setEmployee(true);
        try {
            newEmployee = userService.saveUser(newEmployee);
            user = newEmployee;
        } catch(Exception e){
            addEmployeeForm.recordError("Username already in use.");
        }
    }

    Object onSuccessFromAddEmployeeForm() {
        return Employees.class;
    }

    Object onActivate() {
        if (userExists) {
            if(user.isEmployee())
                return null;
        }
        return Index.class;
    }

}
