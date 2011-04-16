/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.service.impl;

import com.aleksaantelj.carrenting.model.Car;
import com.aleksaantelj.carrenting.model.Customer;
import com.aleksaantelj.carrenting.model.Rent;
import com.aleksaantelj.carrenting.model.beans.RentBean;
import com.aleksaantelj.carrenting.service.RentService;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Aleksa Antelj
 */
public class RentServiceDAO implements RentService {

    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public Rent saveRent(Rent rent) {
        return (Rent) sessionFactory.getCurrentSession().
                get(RentBean.class, sessionFactory.getCurrentSession().save(rent));
    }

    @Transactional
    public void deleteRent(Rent rent) {
        sessionFactory.getCurrentSession().delete(rent);
    }

    @Transactional
    public void updateRent(Rent rent) {
        sessionFactory.getCurrentSession().update(rent);
    }

    @Transactional
    public Rent getRent(int id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RentBean.class).
                add(Restrictions.eq("id",id));
        List rents = criteria.list();
        if(rents.size() > 0)
            return (Rent) rents.get(0);
        return null;
    }


    @Transactional
    public List<Rent> getAllRents() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RentBean.class).
                addOrder(Order.asc("username"));
        return (List<Rent>)criteria.list();
    }

    @Transactional
    public List<Rent> getRentsByCustomer(Customer customer) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RentBean.class).
                add(Restrictions.eq("customer", customer)).addOrder(Order.asc("issueDate"));
        return (List<Rent>)criteria.list();
    }

    @Transactional
    public List<Rent> getRentsByCar(Car car) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RentBean.class).
                add(Restrictions.eq("car", car)).addOrder(Order.asc("issueDate"));
        return (List<Rent>)criteria.list();
    }

}
