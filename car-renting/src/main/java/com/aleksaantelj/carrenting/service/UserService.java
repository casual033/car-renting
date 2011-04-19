/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.service;

import com.aleksaantelj.carrenting.model.User;
import java.util.List;
/**
 *
 * @author Aleksa Antelj
 */
public interface UserService {
    
    User saveUser(User user);

    void deleteUser(User user);

    void updateUser(User user);

    User getUser(int id);

    List<User> getAllUsers();

    List<User> getAllEmployees();

    User authenticateUser(User user);

}
