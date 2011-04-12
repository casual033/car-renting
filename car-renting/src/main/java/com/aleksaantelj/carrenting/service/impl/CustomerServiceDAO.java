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
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Aleksa Antelj
 */
public class CustomerServiceDAO extends UserServiceDAO implements CustomerService {

    public Customer saveCustomer(Customer customer) {
        return (Customer) sessionFactory.getCurrentSession().
                get(customer.getClass(), sessionFactory.getCurrentSession().save(customer));
    }

    public void deleteCustomer(Customer customer) {
        sessionFactory.getCurrentSession().delete(customer);
    }

    public void updateCustomer(Customer customer) {
        sessionFactory.getCurrentSession().update(customer);
    }

    public Customer getCustomer(int id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CustomerBean.class).
                add(Restrictions.eq("id",id));
        List customers = criteria.list();
        if(customers.size()>0)
            return (Customer) customers.get(0);
        return null;
    }

    public List<Customer> getAllCustomers() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CustomerBean.class).
                addOrder(Order.asc("username"));
        return (List<Customer>)criteria.list();
    }

}
