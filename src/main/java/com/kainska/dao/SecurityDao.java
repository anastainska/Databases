package com.kainska.dao;

import com.kainska.model.Security;
import com.kainska.utils.PrepareSession;
import com.kainska.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class SecurityDao {

    public SecurityDao() {
    }

    public Security findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Security.class, id);
    }

    public List<Security> findAll() {
        List<Security> SecurityList = (List<Security>) HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().createQuery("from Security ").list();
        return SecurityList;
    }

    public static PrepareSession prepareSession() {
        PrepareSession ps = new PrepareSession();
        ps.s = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        ps.t = ps.s.beginTransaction();
        return ps;
    }

    public void create(Security security) {
        PrepareSession ps = prepareSession();
        ps.s.save(security);
        ps.t.commit();
        ps.s.close();
    }

    public void update(Security security) {
        PrepareSession ps = prepareSession();
        ps.s.update(security);
        ps.t.commit();
        ps.s.close();
    }

    public void delete(Security security) {
        PrepareSession ps = prepareSession();
        ps.s.delete(security);
        ps.t.commit();
        ps.s.close();
    }

}
