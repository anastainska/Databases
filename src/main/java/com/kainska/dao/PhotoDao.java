package com.kainska.dao;

import com.kainska.model.Photo;
import com.kainska.utils.PrepareSession;
import com.kainska.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class PhotoDao {

    public PhotoDao() {
    }

    public Photo findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Photo.class, id);
    }

    public List<Photo> findAll() {
        List<Photo> PhotoList = (List<Photo>) HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().createQuery("from Photo ").list();
        return PhotoList;
    }

    public void create(Photo photo) {
        PrepareSession ps = new PrepareSession();
        ps.s.save(photo);
        ps.t.commit();
        ps.s.close();
    }

    public void update(Photo photo) {
        PrepareSession ps = new PrepareSession();
        ps.s.update(photo);
        ps.t.commit();
        ps.s.close();
    }

    public void delete(Photo Photo) {
        PrepareSession ps = new PrepareSession();
        ps.s.delete(Photo);
        ps.t.commit();
        ps.s.close();
    }

}
