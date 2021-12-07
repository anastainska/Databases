package com.kainska.dao;

import com.kainska.model.User;
import com.kainska.utils.PrepareSession;
import com.kainska.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class UserDao {

    public UserDao() {
    }

    public User findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }

    public List<User> findAll() {
        List<User> userList = (List<User>) HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().createQuery("from User ").list();
        return userList;
    }

    public static PrepareSession prepareSession() {
        PrepareSession ps = new PrepareSession();
        ps.s = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        ps.t = ps.s.beginTransaction();
        return ps;
    }

    public void create(User user) {
        PrepareSession ps = prepareSession();
        ps.s.save(user);
        ps.t.commit();
        ps.s.close();
    }

    public void update(User user) {
        PrepareSession ps = prepareSession();
        ps.s.update(user);
        ps.t.commit();
        ps.s.close();
    }

    public void delete(User user) {
        PrepareSession ps = prepareSession();
        ps.s.delete(user);
        ps.t.commit();
        ps.s.close();
    }

}
