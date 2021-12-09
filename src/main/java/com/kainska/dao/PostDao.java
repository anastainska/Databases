package com.kainska.dao;

import com.kainska.model.Post;
import com.kainska.utils.ConnectionJDBC;

import java.sql.*;
import java.util.ArrayList;

public class PostDao {

    public PostDao() {
    }

    private boolean initializeValues(String method, Post post, PreparedStatement ps) throws SQLException  {
        if (method.equals("update")) {
            ps.setInt(5, post.getId());
            ps.setInt(1, post.getUserId());
            ps.setString(2, post.getText());
            ps.setByte(3, post.getPhoto());
            ps.setTimestamp(4, post.getDatePost());
        } else if (method.equals("create")) {
            ps.setInt(5, post.getId());
            ps.setInt(1, post.getUserId());
            ps.setString(2, post.getText());
            ps.setByte(3, post.getPhoto());
            ps.setTimestamp(4, post.getDatePost());
        }
        int i = ps.executeUpdate();
        return i == 1;
    }

    public Post findById(int id) {
        Post post = new Post();
        Connection c = ConnectionJDBC.getConnection();
        try {
            ResultSet res = c.createStatement().executeQuery("SELECT * FROM post WHERE id="+ id);
            while (res.next()) {
                post.setId(res.getInt("id"));
                post.setUserId(res.getInt("user_id"));
                post.setText(res.getString("text"));
                post.setPhoto(res.getByte("photo"));
                post.setDatePost(res.getTimestamp("date_post"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }

    public ArrayList<String[]> findAll() {
        ArrayList <String[]> result = new ArrayList<>();
        Connection c = ConnectionJDBC.getConnection();
        try {
            ResultSet res = c.createStatement().executeQuery("SELECT * FROM post");
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


    public boolean create(Post post) {
        Connection c = ConnectionJDBC.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement(
                    "INSERT INTO post VALUES (NULL, ?, ?, ?, ?, ?)");
            if (initializeValues("create", post, ps)) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Post post) {
        Connection c = ConnectionJDBC.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement(
                    "UPDATE post SET user_id=?, text=?," +
                            " photo=?, date_post=? WHERE id=?");
            if (initializeValues("update", post, ps)) return true;
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
            int i = stmt.executeUpdate("DELETE FROM post WHERE id=" + id);
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