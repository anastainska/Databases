package com.kainska.dao;

import com.kainska.model.Message;
import com.kainska.utils.ConnectionJDBC;

import java.sql.*;
import java.util.ArrayList;

public class MessageDao {

    public MessageDao() {
    }

    private boolean initializeValues(String method, Message message, PreparedStatement ps) throws SQLException  {
        if (method.equals("update")) {
            ps.setInt(5, message.getId());
            ps.setString(1, message.getTextMessage());
            ps.setTimestamp(2, message.getTimeCreation());
            ps.setTimestamp(3, message.getTimeSeen());
            ps.setInt(4, message.getUserId());
        } else if (method.equals("create")) {
            ps.setInt(5, message.getId());
            ps.setString(1, message.getTextMessage());
            ps.setTimestamp(2, message.getTimeCreation());
            ps.setTimestamp(3, message.getTimeSeen());
            ps.setInt(4, message.getUserId());
        }
        int i = ps.executeUpdate();
        return i == 1;
    }

    public Message findById(int id) {
        Message message = new Message();
        Connection c = ConnectionJDBC.getConnection();
        try {
            ResultSet res = c.createStatement().executeQuery("SELECT * FROM message WHERE id="+ id);
            while (res.next()) {
                message.setId(res.getInt("id"));
                message.setTextMessage(res.getString("text_message"));
                message.setTimeCreation(res.getTimestamp("time_creation"));
                message.setTimeSeen(res.getTimestamp("time_seen"));
                message.setUserId(res.getInt("user_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return message;
    }

    public ArrayList<String[]> findAll() {
        ArrayList <String[]> result = new ArrayList<>();
        Connection c = ConnectionJDBC.getConnection();
        try {
            ResultSet res = c.createStatement().executeQuery("SELECT * FROM message");
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


    public boolean create(Message message) {
        Connection c = ConnectionJDBC.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement(
                    "INSERT INTO message VALUES (NULL, ?, ?, ?, ?, ?, ?)");
            if (initializeValues("create", message, ps)) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Message message) {
        Connection c = ConnectionJDBC.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement(
                    "UPDATE message SET text_message=?, time_creation=?," +
                            " time_seen=?, user_id=? WHERE id=?");
            if (initializeValues("update", message, ps)) return true;
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
            int i = stmt.executeUpdate("DELETE FROM message WHERE id=" + id);
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