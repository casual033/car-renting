package com.aleksaantelj.carrenting.components;

import org.apache.tapestry5.*;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.ioc.annotations.*;
import org.apache.tapestry5.BindingConstants;

/**
 * Layout component for pages of application car-renting.
 */
@IncludeStylesheet("context:layout/layout.css")
public class Layout
{
    /** The page title, for the <title> element and the <h1> element. */
    @Property
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    private String title;

    @Property
    private String pageName;

//    @Property
//    @Parameter(required=false, value="false", defaultPrefix = BindingConstants.LITERAL)
//    private boolean isEmployee;
//
//    @Property
//    @Parameter(required = false, value="false",defaultPrefix = BindingConstants.LITERAL)
//    private boolean isCustomer;
//
//    @Property
//    @Parameter(required = false, value="true",defaultPrefix = BindingConstants.LITERAL)
//    private boolean userMenu;


    @Inject
    private ComponentResources resources;

    public String getClassForPageName()
    {
      return resources.getPageName().equalsIgnoreCase(pageName)
             ? "current_page_item"
             : null;
    }

    public String[] getPageNames()
    {
      return new String[] { "Index", "About", "Contact" };
    }
}
