/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aleksaantelj.carrenting.service.impl;

import com.aleksaantelj.carrenting.model.User;
import com.aleksaantelj.carrenting.model.beans.UserBean;
import com.aleksaantelj.carrenting.service.UserService;
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
public class UserServiceDAO implements UserService {

    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public User saveUser(User user) {
        return (User) sessionFactory.getCurrentSession().get
                (user.getClass(), sessionFactory.getCurrentSession().save(user));
    }

    @Transactional
    public void deleteUser(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @Transactional
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Transactional
    public User getUser(int id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserBean.class).
                add(Restrictions.eq("id",id));
        List users = criteria.list();
        if(users.size() > 0)
            return (User) users.get(0);
        return null;
    }

    public List<User> getAllUsers() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserBean.class).
                addOrder(Order.asc("username"));
        return (List<User>)criteria.list();
    }

    @Transactional
    public User authenticateUser(User user) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserBean.class).
                add(Restrictions.eq("username", user.getUsername())).
                add(Restrictions.eq("password", user.getPassword()));
        List list = criteria.list();
        if(list == null || list.isEmpty())
            return null;
        return (User) list.get(0);
    }

    @Transactional
    public List<User> getAllEmployees() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserBean.class).
                add(Restrictions.eq("employee", true)).
                addOrder(Order.asc("username"));
        return (List<User>)criteria.list();
    }

}
