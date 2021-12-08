package com.kainska.dao;

import com.kainska.model.Comment;
import com.kainska.utils.ConnectionJDBC;
import com.kainska.utils.PrepareSession;
import com.kainska.utils.HibernateSessionFactoryUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDao {

    public CommentDao() {
    }

    public Comment findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Comment.class, id);
    }

    public ArrayList <String[]> findAll() throws SQLException {
        ArrayList <String[]> result = new ArrayList<>();
        Connection c = ConnectionJDBC.getConnection();
        ResultSet res = c.createStatement().executeQuery("SELECT * FROM comment");
        int columnCount = res.getMetaData().getColumnCount();
        while (res.next()) {
            String[] row = new String[columnCount];
            for (int i=0; i <columnCount ; i++)
            {
                row[i] = res.getString(i + 1);
            }
            result.add(row);
        }
        return result;

//        List<Comment> CommentList = (List<Comment>) HibernateSessionFactoryUtil.getSessionFactory()
//                .openSession().createQuery("from Comment ").list();
//        return CommentList;
    }

    public void create(Comment comment) {
        PrepareSession ps = new PrepareSession();
        ps.s.save(comment);
        ps.t.commit();
        ps.s.close();
    }

    public void update(Comment comment) {
        PrepareSession ps = new PrepareSession();
        ps.s.update(comment);
        ps.t.commit();
        ps.s.close();
    }

    public void delete(Comment comment) {
        ConnectionJDBC c = new ConnectionJDBC();
        ConnectionJDBC.prepareJDBCSession(c);
        PrepareSession ps = new PrepareSession();
        ps.prepareSession();
        ps.s.delete(comment);
        ps.t.commit();
        ps.s.close();
    }

}
