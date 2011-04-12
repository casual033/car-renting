package com.aleksaantelj.carrenting.pages;

import com.aleksaantelj.carrenting.model.User;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;

/**
 * Start page of application car-renting.
 */
public class Index
{

    @SessionState
    private User user;

    private boolean userExists;
    
    

    Object onActivate() {
        if (userExists) {
            return null;
        }
        return Login.class;
    }
}
