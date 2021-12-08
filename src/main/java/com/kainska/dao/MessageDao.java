package com.kainska.dao;

import com.kainska.model.Message;
import com.kainska.utils.PrepareSession;
import com.kainska.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class MessageDao {

    public MessageDao() {
    }

    public Message findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Message.class, id);
    }

    public List<Message> findAll() {
        List<Message> MessageList = (List<Message>) HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().createQuery("from Message ").list();
        return MessageList;
    }

    public void create(Message message) {
        PrepareSession ps = new PrepareSession();
        ps.s.save(message);
        ps.t.commit();
        ps.s.close();
    }

    public void update(Message message) {
        PrepareSession ps = new PrepareSession();
        ps.s.update(message);
        ps.t.commit();
        ps.s.close();
    }

    public void delete(Message message) {
        PrepareSession ps = new PrepareSession();
        ps.s.delete(message);
        ps.t.commit();
        ps.s.close();
    }

}
