/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.model.beans;

import com.aleksaantelj.carrenting.model.Customer;
import com.aleksaantelj.carrenting.model.Rent;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;


/**
 *
 * @author Aleksa Antelj
 */
@Entity
public class CustomerBean extends UserBean implements Customer  {

    private String firstName;
    private String lastName;
    private String jmbg;
    private String email;
    private String homeAddress;
    private List<Rent> customerRents;

    @OneToMany(targetEntity=RentBean.class,mappedBy="customer",cascade=CascadeType.ALL,
                    fetch=FetchType.LAZY)
    public List<Rent> getCustomerRents() {
        return customerRents;
    }

    public void setCustomerRents(List<Rent> customerRents) {
        this.customerRents = customerRents;
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
