/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Aleksa Antelj
 */
public interface User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int getId();

    String getPassword();

    String getUsername();

    boolean isEmployee();

    void setId(int id);

    void setPassword(String password);

    void setUsername(String username);

    void setEmployee(boolean employee);

}
