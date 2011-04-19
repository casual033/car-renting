/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.pages;

import com.aleksaantelj.carrenting.model.User;
import com.aleksaantelj.carrenting.service.UserService;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Aleksa Antelj
 */
public class Employees {

    @SessionState
    @Property
    private User user;
    private boolean userExists;

    @Inject
    @Property
    private UserService userService;

    @Property
    private User currentUser;

    Object onActivate() {
        if (userExists) {
            if(user.isEmployee())
                return null;
        }
        return Index.class;
    }

}
