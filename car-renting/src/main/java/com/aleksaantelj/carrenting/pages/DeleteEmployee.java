/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.pages;

import com.aleksaantelj.carrenting.model.User;
import com.aleksaantelj.carrenting.service.UserService;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Aleksa Antelj
 */
public class DeleteEmployee {

    @SessionState
    private User user;
    private boolean userExists;
    
    @Inject
    private UserService userService;

    Object onActivate(int empId) {
        if (userExists) {
            if(user.isEmployee())
                if(user.getId() != empId)
                    userService.deleteUser(userService.getUser(empId));
        }
        return Employees.class;
    }
}
