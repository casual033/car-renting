/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.model;

import java.util.List;

/**
 *
 * @author Aleksa Antelj
 */
public interface Customer extends User {

    String getEmail();

    String getFirstName();

    String getHomeAddress();

    String getJmbg();

    String getLastName();

    public List<Rent> getCustomerRents();

    public void setCustomerRents(List<Rent> customerRents);

    void setEmail(String email);

    void setFirstName(String firstName);

    void setHomeAddress(String homeAddress);

    void setJmbg(String jmbg);

    void setLastName(String lastName);


}
