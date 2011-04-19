/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;

/**
 *
 * @author Aleksa Antelj
 */
public class UserMenu {

    @Property
    @Parameter(required=false, value="false", defaultPrefix = BindingConstants.LITERAL)
    private boolean isEmployee;

    @Property
    @Parameter(required = false, value="false",defaultPrefix = BindingConstants.LITERAL)
    private boolean isCustomer;

    @Property
    @Parameter(required = false, value="1",defaultPrefix = BindingConstants.LITERAL)
    private int userId;

}
