package com.kainska.utils;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class PrepareSession {
    public Session s;
    public Transaction t;

    public PrepareSession prepareSession() {
        PrepareSession ps = new PrepareSession();
        ps.s = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        ps.t = ps.s.beginTransaction();
        return ps;
    }
}
