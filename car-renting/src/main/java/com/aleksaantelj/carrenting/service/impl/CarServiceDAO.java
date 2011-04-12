/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.service.impl;

import com.aleksaantelj.carrenting.model.Car;
import com.aleksaantelj.carrenting.model.beans.CarBean;
import com.aleksaantelj.carrenting.service.CarService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Aleksa Antelj
 */
public class CarServiceDAO implements CarService {
    
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Car saveCar(Car car) {
        return (Car) sessionFactory.getCurrentSession().
                get(car.getClass(), sessionFactory.getCurrentSession().save(car));
    }

    public void deleteCar(Car car) {
        sessionFactory.getCurrentSession().delete(car);
    }

    public void updateCar(Car car) {
        sessionFactory.getCurrentSession().update(car);
    }

    public Car getCar(int id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CarBean.class).
                add(Restrictions.eq("id",id));
        List cars = criteria.list();
        if(cars.size() > 0)
            return (Car) cars.get(0);
        return null;
    }

    public List<Car> getAllCars() {
        Criteria criteria = null;
        try {
            criteria = sessionFactory.getCurrentSession().createCriteria(Class.forName("CarBean")).addOrder(Order.asc("brand"));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CarServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (List<Car>)criteria.list();
    }

}
