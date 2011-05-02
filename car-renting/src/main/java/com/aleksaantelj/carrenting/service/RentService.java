/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.service;

import com.aleksaantelj.carrenting.model.Car;
import com.aleksaantelj.carrenting.model.Customer;
import com.aleksaantelj.carrenting.model.Rent;
import java.util.List;

/**
 *
 * @author Aleksa Antelj
 */
public interface RentService {

    Rent saveRent(Rent rent);

    void deleteRent(Rent rent);

    void updateRent(Rent rent);

    Rent getRent(int id);

    List<Rent> getAllRents();

    List<Rent> getRentsByCustomer(Customer customer);

    List<Rent> getRentsByCar(Car car);

    public boolean getCarAvailable(Car car);

    public void returnCar(Car car);

}
