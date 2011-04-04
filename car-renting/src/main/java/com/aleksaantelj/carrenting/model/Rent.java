/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.model;

import java.util.Date;

/**
 *
 * @author Aleksa Antelj
 */
public interface Rent {

    int getCarId();

    Date getIssueDate();

    Date getReturnDate();

    int getUserId();

    boolean isReturned();

    void setCarId(int carId);

    void setIssueDate(Date issueDate);

    void setReturnDate(Date returnDate);

    void setReturned(boolean returned);

    void setUserId(int userId);

}
