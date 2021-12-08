package com.kainska.dao;

import com.kainska.model.LikeComment;
import com.kainska.utils.PrepareSession;
import com.kainska.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class LikeCommentDao {

    public LikeCommentDao() {
    }

    public LikeComment findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(LikeComment.class, id);
    }

    public List<LikeComment> findAll() {
        List<LikeComment> LikeCommentList = (List<LikeComment>) HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().createQuery("from LikeComment ").list();
        return LikeCommentList;
    }

    public void create(LikeComment likeComment) {
        PrepareSession ps = new PrepareSession();
        ps.s.save(likeComment);
        ps.t.commit();
        ps.s.close();
    }

    public void update(LikeComment likeComment) {
        PrepareSession ps = new PrepareSession();
        ps.s.update(likeComment);
        ps.t.commit();
        ps.s.close();
    }

    public void delete(LikeComment likeComment) {
        PrepareSession ps = new PrepareSession();
        ps.s.delete(likeComment);
        ps.t.commit();
        ps.s.close();
    }

}
