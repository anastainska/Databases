package com.kainska.dao;

import com.kainska.model.LikeComment;
import com.kainska.utils.ConnectionJDBC;

import java.sql.*;
import java.util.ArrayList;

public class LikeCommentDao {

    public LikeCommentDao() {
    }

    private boolean initializeValues(String method, LikeComment likeComment, PreparedStatement ps) throws SQLException  {
        if (method.equals("update")) {
            ps.setInt(2, likeComment.getId());
            ps.setInt(1, likeComment.getCommentId());
        } else if (method.equals("create")) {
            ps.setInt(2, likeComment.getId());
            ps.setInt(1, likeComment.getCommentId());
        }
        int i = ps.executeUpdate();
        return i == 1;
    }

    public LikeComment findById(int id) {
        LikeComment likeComment = new LikeComment();
        Connection c = ConnectionJDBC.getConnection();
        try {
            ResultSet res = c.createStatement().executeQuery("SELECT * FROM like_comment WHERE id="+ id);
            while (res.next()) {
                likeComment.setId(res.getInt("id"));
                likeComment.setCommentId(res.getInt("comment_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return likeComment;
    }

    public ArrayList<String[]> findAllLikeComment() {
        ArrayList <String[]> result = new ArrayList<>();
        Connection c = ConnectionJDBC.getConnection();
        try {
            ResultSet res = c.createStatement().executeQuery("SELECT * FROM like_comment");
            int columnCount = res.getMetaData().getColumnCount();
            while (res.next()) {
                String[] row = new String[columnCount];
                for (int i=0; i <columnCount ; i++)
                {
                    row[i] = res.getString(i + 1);
                }
                result.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    public boolean create(LikeComment likeComment) {
        Connection c = ConnectionJDBC.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement(
                    "INSERT INTO like_comment VALUES (NULL, ?, ?, ?)");
            if (initializeValues("create", likeComment, ps)) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(LikeComment likeComment) {
        Connection c = ConnectionJDBC.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement(
                    "UPDATE like_comment SET comment_id=?, WHERE id=?");
            if (initializeValues("update", likeComment, ps)) return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        Connection c = ConnectionJDBC.getConnection();
        try {
            Statement stmt = c.createStatement();
            int i = stmt.executeUpdate("DELETE FROM like_comment WHERE id=" + id);
            if(i == 1) {
                return true;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}