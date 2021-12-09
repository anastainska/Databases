package com.kainska.dao;

import com.kainska.model.Comment;
import com.kainska.utils.ConnectionJDBC;

import java.sql.*;
import java.util.ArrayList;

public class CommentDao {

    public CommentDao() {
    }

    private boolean initializeValues(String method, Comment comment, PreparedStatement ps) throws SQLException  {
        if (method.equals("update")) {
            ps.setInt(4, comment.getId());
            ps.setString(1, comment.getText());
            ps.setInt(2, comment.getPostId());
            ps.setTimestamp(3, comment.getDateComment());
        } else if (method.equals("create")) {
            ps.setInt(4, comment.getId());
            ps.setString(1, comment.getText());
            ps.setInt(2, comment.getPostId());
            ps.setTimestamp(3, comment.getDateComment());
        }
        int i = ps.executeUpdate();
        return i == 1;
    }

    public Comment findById(int id) {
        Comment comment = new Comment();
        Connection c = ConnectionJDBC.getConnection();
        try {
            ResultSet res = c.createStatement().executeQuery("SELECT * FROM comment WHERE id="+ id);
            while (res.next()) {
                comment.setId(res.getInt("id"));
                comment.setText(res.getString("text"));
                comment.setPostId(res.getInt("post_id"));
                comment.setDateComment(res.getTimestamp("date_comment"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comment;
    }

    public ArrayList <String[]> findAll() {
        ArrayList <String[]> result = new ArrayList<>();
        Connection c = ConnectionJDBC.getConnection();
        try {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean create(Comment comment) {
        Connection c = ConnectionJDBC.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement(
                    "INSERT INTO comment VALUES (NULL, ?, ?, ?, ?, ?)");
            if (initializeValues("create", comment, ps)) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Comment comment) {
        Connection c = ConnectionJDBC.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement(
                    "UPDATE comment SET text=?, post_id=?," +
                            " date_comment=? WHERE id=?");
            if (initializeValues("update", comment, ps)) return true;
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
            int i = stmt.executeUpdate("DELETE FROM comment WHERE id=" + id);
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