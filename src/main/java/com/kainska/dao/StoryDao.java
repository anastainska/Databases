package com.kainska.dao;

import com.kainska.model.Story;
import com.kainska.utils.ConnectionJDBC;

import java.sql.*;
import java.util.ArrayList;

public class StoryDao {

    public StoryDao() {
    }

    private boolean initializeValues(String method, Story story, PreparedStatement ps) throws SQLException  {
        if (method.equals("update")) {
            ps.setInt(3, story.getId());
            ps.setString(1, story.getReactions());
            ps.setInt(2, story.getUserId());
        }  else if (method.equals("create")) {
            ps.setInt(3, story.getId());
            ps.setString(1, story.getReactions());
            ps.setInt(2, story.getUserId());
        }
        int i = ps.executeUpdate();
        return i == 1;
    }

    public Story findById(int id) {
        Story story = new Story();
        Connection c = ConnectionJDBC.getConnection();
        try {
            ResultSet res = c.createStatement().executeQuery("SELECT * FROM story WHERE id="+ id);
            while (res.next()) {
                story.setId(res.getInt("id"));
                story.setReactions(res.getString("reactions"));
                story.setUserId(res.getInt("user_iduser"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return story;
    }

    public ArrayList<String[]> findAll() {
        ArrayList <String[]> result = new ArrayList<>();
        Connection c = ConnectionJDBC.getConnection();
        try {
            ResultSet res = c.createStatement().executeQuery("SELECT * FROM story");
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

    public boolean create(Story story) {
        Connection c = ConnectionJDBC.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement(
                    "INSERT INTO post VALUES (NULL, ?, ?, ?)");
            if (initializeValues("create", story, ps)) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Story story) {
        Connection c = ConnectionJDBC.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement(
                    "UPDATE story SET reactions=?, user_iduser=? WHERE id=?");
            if (initializeValues("update", story, ps)) return true;
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
            int i = stmt.executeUpdate("DELETE FROM story WHERE id=" + id);
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