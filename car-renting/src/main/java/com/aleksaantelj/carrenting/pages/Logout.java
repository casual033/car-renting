/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.pages;

import com.aleksaantelj.carrenting.model.User;
import org.apache.tapestry5.annotations.SessionState;

/**
 *
 * @author Aleksa Antelj
 */
public class Logout {

    @SessionState
    private User user;
    private boolean userExists;

    Object onActivate() {
        if (userExists) {
            user = null;
        }
        return Index.class;
    }

}
