package com.kainska.dao;

import com.kainska.model.LikePost;
import com.kainska.utils.PrepareSession;
import com.kainska.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class LikePostDao {

    public LikePostDao() {
    }

    public LikePost findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(LikePost.class, id);
    }

    public List<LikePost> findAll() {
        List<LikePost> LikePostList = (List<LikePost>) HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().createQuery("from LikePost ").list();
        return LikePostList;
    }

    public void create(LikePost likePost) {
        PrepareSession ps = new PrepareSession();
        ps.s.save(likePost);
        ps.t.commit();
        ps.s.close();
    }

    public void update(LikePost likePost) {
        PrepareSession ps = new PrepareSession();
        ps.s.update(likePost);
        ps.t.commit();
        ps.s.close();
    }

    public void delete(LikePost likePost) {
        PrepareSession ps = new PrepareSession();
        ps.s.delete(likePost);
        ps.t.commit();
        ps.s.close();
    }

}
