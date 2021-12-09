package com.kainska.dao;

import com.kainska.model.LikePost;
import com.kainska.utils.ConnectionJDBC;

import java.sql.*;
import java.util.ArrayList;

public class LikePostDao {

    public LikePostDao() {
    }

    private boolean initializeValues(String method, LikePost likePost, PreparedStatement ps) throws SQLException  {
        if (method.equals("update")) {
            ps.setInt(3, likePost.getId());
            ps.setInt(2, likePost.getPostId());
            ps.setTimestamp(3, likePost.getTimeCreationLike());
        }else if (method.equals("create")) {
            ps.setInt(3, likePost.getId());
            ps.setInt(2, likePost.getPostId());
            ps.setTimestamp(3, likePost.getTimeCreationLike());
        }
        int i = ps.executeUpdate();
        return i == 1;
    }

    public LikePost findById(int id) {
        LikePost likePost = new LikePost();
        Connection c = ConnectionJDBC.getConnection();
        try {
            ResultSet res = c.createStatement().executeQuery("SELECT * FROM like_post WHERE id="+ id);
            while (res.next()) {
                likePost.setId(res.getInt("idlike_post"));
                likePost.setPostId(res.getInt("post_id"));
                likePost.setTimeCreationLike(res.getTimestamp("time_creation_like"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return likePost;
    }

    public ArrayList<String[]> findAll() {
        ArrayList <String[]> result = new ArrayList<>();
        Connection c = ConnectionJDBC.getConnection();
        try {
            ResultSet res = c.createStatement().executeQuery("SELECT * FROM like_post");
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


    public boolean create(LikePost likePost) {
        Connection c = ConnectionJDBC.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement(
                    "INSERT INTO like_post VALUES (NULL, ?, ?, ?, ?)");
            if (initializeValues("create", likePost, ps)) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(LikePost likePost) {
        Connection c = ConnectionJDBC.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement(
                    "UPDATE like_post SET post_id=?," +
                            " time_creation_like=? WHERE idlike_post=?");
            if (initializeValues("update", likePost, ps)) return true;
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
            int i = stmt.executeUpdate("DELETE FROM like_post WHERE idlike_post=" + id);
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