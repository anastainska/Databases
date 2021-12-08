package com.kainska.dao;

import com.kainska.model.Story;
import com.kainska.utils.PrepareSession;
import com.kainska.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class StoryDao {

    public StoryDao() {
    }

    public Story findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Story.class, id);
    }

    public List<Story> findAll() {
        List<Story> StoryList = (List<Story>) HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().createQuery("from Story ").list();
        return StoryList;
    }

    public static PrepareSession prepareSession() {
        PrepareSession ps = new PrepareSession();
        ps.s = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        ps.t = ps.s.beginTransaction();
        return ps;
    }

    public void create(Story story) {
        PrepareSession ps = prepareSession();
        ps.s.save(story);
        ps.t.commit();
        ps.s.close();
    }

    public void update(Story story) {
        PrepareSession ps = prepareSession();
        ps.s.update(story);
        ps.t.commit();
        ps.s.close();
    }

    public void delete(Story story) {
        PrepareSession ps = prepareSession();
        ps.s.delete(story);
        ps.t.commit();
        ps.s.close();
    }

}
