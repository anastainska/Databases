package com.kainska.dao;

import com.kainska.model.Security;
import com.kainska.utils.ConnectionJDBC;

import java.sql.*;
import java.util.ArrayList;

public class SecurityDao {

    public SecurityDao() {
    }

    private boolean initializeValues(String method, Security security, PreparedStatement ps) throws SQLException  {
        if (method.equals("update")) {
            ps.setInt(5, security.getId());
            ps.setString(1, security.getNickname());
            ps.setString(2, security.getPassword());
            ps.setInt(3, security.getUserId());
        }  else if (method.equals("create")) {
            ps.setInt(5, security.getId());
            ps.setString(1, security.getNickname());
            ps.setString(2, security.getPassword());
            ps.setInt(3, security.getUserId());
        }
        int i = ps.executeUpdate();
        return i == 1;
    }

    public Security findById(int id) {
        Security security = new Security();
        Connection c = ConnectionJDBC.getConnection();
        try {
            ResultSet res = c.createStatement().executeQuery("SELECT * FROM security WHERE id="+ id);
            while (res.next()) {
                security.setId(res.getInt("id"));
                security.setNickname(res.getString("nickname"));
                security.setPassword(res.getString("password"));
                security.setUserId(res.getInt("user_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return security;
    }

    public ArrayList<String[]> findAll() {
        ArrayList <String[]> result = new ArrayList<>();
        Connection c = ConnectionJDBC.getConnection();
        try {
            ResultSet res = c.createStatement().executeQuery("SELECT * FROM security");
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

    public boolean create(Security security) {
        Connection c = ConnectionJDBC.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement(
                    "INSERT INTO post VALUES (NULL, ?, ?, ?, ?)");
            if (initializeValues("create", security, ps)) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Security security) {
        Connection c = ConnectionJDBC.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement(
                    "UPDATE security SET nickname=?, password=?," +
                            " user_id=? WHERE id=?");
            if (initializeValues("update", security, ps)) return true;
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
            int i = stmt.executeUpdate("DELETE FROM security WHERE id=" + id);
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