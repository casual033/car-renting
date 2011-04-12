/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.pages;

import com.aleksaantelj.carrenting.model.User;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
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




}
