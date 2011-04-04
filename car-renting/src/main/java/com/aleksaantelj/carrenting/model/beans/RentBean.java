/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.model.beans;

import com.aleksaantelj.carrenting.model.Rent;
import java.util.Date;

/**
 *
 * @author Aleksa Antelj
 */
public class RentBean implements Rent {

    private int userId;
    private int carId;
    private Date issueDate;
    private Date returnDate;
    private boolean returned;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
