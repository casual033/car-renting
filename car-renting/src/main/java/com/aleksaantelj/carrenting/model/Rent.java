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

    Date getIssueDate();

    Date getReturnDate();

    boolean isReturned();

    void setIssueDate(Date issueDate);

    void setReturnDate(Date returnDate);

    void setReturned(boolean returned);


}
