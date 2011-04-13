/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.pages;

import com.aleksaantelj.carrenting.model.User;
import com.aleksaantelj.carrenting.model.beans.UserBean;
import com.aleksaantelj.carrenting.service.UserService;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.PasswordField;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Aleksa Antelj
 */
public class Login {

    @SessionState
    private User user;

    @Persist
    @Property
    private String username;

    @Property
    private String password;

    private boolean userExists;

    @Inject
    private UserService userService;

    @Component
    private Form userLoginForm;

    @Component(id = "password")
    private PasswordField passwordField;


    void onValidateFromUserLoginForm() {

        User loginUser = new UserBean();
        loginUser.setUsername(username);
        loginUser.setPassword(password);
        loginUser = userService.authenticateUser(loginUser);
        if (loginUser == null || username == null || password == null || username.length() < 5 || password.length() < 5) {
            username = null;
            password = null;
            userLoginForm.recordError(passwordField, "Wrong username and password combination!");
        } else {
            user = loginUser;
        }
    }

    Object onSuccessFromUserLoginForm() {
        return Index.class;
    }

    Object onActivate() {
        if (userExists) {
            return Index.class;
        }
        return null;
    }


}
