/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.model;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Aleksa Antelj
 */
public interface Rent {


    Car getCar();

    Customer getCustomer();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int getId();

    @Temporal(value = TemporalType.DATE)
    Date getIssueDate();

    @Temporal(value = TemporalType.DATE)
    Date getReturnDate();

    boolean isReturned();

    void setCar(Car car);

    void setCustomer(Customer customer);

    void setId(int id);

    void setIssueDate(Date issueDate);

    void setReturnDate(Date returnDate);

    void setReturned(boolean returned);


}
