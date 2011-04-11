/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.service;

import com.aleksaantelj.carrenting.model.Customer;
import java.util.List;

/**
 *
 * @author Aleksa Antelj
 */
public interface CustomerService extends UserService {

    Customer saveCustomer(Customer customer);

    void deleteCustomer(Customer customer);

    void updateCustomer(Customer customer);

    Customer getCustomer(int id);

    List<Customer> getAllCustomers();
}
