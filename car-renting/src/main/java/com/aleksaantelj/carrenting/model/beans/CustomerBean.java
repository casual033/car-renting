/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.model.beans;

import com.aleksaantelj.carrenting.model.Customer;
import com.aleksaantelj.carrenting.model.Rent;
import java.util.List;


/**
 *
 * @author Aleksa Antelj
 */
public class CustomerBean extends UserBean implements Customer  {

    private String firstName;
    private String lastName;
    private String jmbg;
    private String email;
    private String homeAddress;
    private List<Rent> userRents;

    public List<Rent> getUserRents() {
        return userRents;
    }

    public void setUserRents(List<Rent> userRents) {
        this.userRents = userRents;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
