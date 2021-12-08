package com.kainska.dao;

import com.kainska.model.Post;
import com.kainska.utils.PrepareSession;
import com.kainska.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class PostDao {

    public PostDao() {
    }

    public Post findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Post.class, id);
    }

    public List<Post> findAll() {
        List<Post> PostList = (List<Post>) HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().createQuery("from Post ").list();
        return PostList;
    }

    public void create(Post post) {
        PrepareSession ps = new PrepareSession();
        ps.s.save(post);
        ps.t.commit();
        ps.s.close();
    }

    public void update(Post post) {
        PrepareSession ps = new PrepareSession();
        ps.s.update(post);
        ps.t.commit();
        ps.s.close();
    }

    public void delete(Post post) {
        PrepareSession ps = new PrepareSession();
        ps.s.delete(post);
        ps.t.commit();
        ps.s.close();
    }

}
