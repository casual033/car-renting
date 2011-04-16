/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.service.impl;

import com.aleksaantelj.carrenting.model.Customer;
import com.aleksaantelj.carrenting.model.beans.CustomerBean;
import com.aleksaantelj.carrenting.service.CustomerService;
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
public class CustomerServiceDAO implements CustomerService {

    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public Customer saveCustomer(Customer customer) {
        return (Customer) sessionFactory.getCurrentSession().
                get(customer.getClass(), sessionFactory.getCurrentSession().save(customer));
    }

    @Transactional
    public void deleteCustomer(Customer customer) {
        sessionFactory.getCurrentSession().delete(customer);
    }

    @Transactional
    public void updateCustomer(Customer customer) {
        sessionFactory.getCurrentSession().update(customer);
    }

    @Transactional
    public Customer getCustomer(int id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CustomerBean.class).
                add(Restrictions.eq("id",id));
        List customers = criteria.list();
        if(customers.size()>0)
            return (Customer) customers.get(0);
        return null;
    }

    @Transactional
    public List<Customer> getAllCustomers() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CustomerBean.class).
                addOrder(Order.asc("username"));
        return (List<Customer>)criteria.list();
    }

}
