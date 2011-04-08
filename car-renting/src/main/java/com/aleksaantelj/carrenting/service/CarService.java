/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.service;

import com.aleksaantelj.carrenting.model.Car;
import java.util.List;

/**
 *
 * @author Aleksa Antelj
 */
public interface CarService {

    Car saveCar(Car car);

    void deleteCar(Car car);

    void updateCar(Car car);

    Car getCar(int id);

    List<Car> getAllCars();

}
