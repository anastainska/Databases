package com.kainska.dao;

import com.kainska.model.User;
import com.kainska.utils.ConnectionJDBC;

import java.sql.*;
import java.util.ArrayList;

public class UserDao {

    public UserDao() {
    }

    private boolean initializeValues(String method, User user, PreparedStatement ps) throws SQLException  {
        if (method.equals("update")) {
            ps.setInt(7, user.getId());
            ps.setInt(1, user.getFollowers());
            ps.setInt(2, user.getFollowings());
            ps.setString(3, user.getDescription());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPhoneNumber());
            ps.setString(6, user.getMention());
        } else if (method.equals("create")) {
            ps.setInt(1, user.getFollowers());
            ps.setInt(2, user.getFollowings());
            ps.setString(3, user.getDescription());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPhoneNumber());
            ps.setString(6, user.getMention());
        }
        int i = ps.executeUpdate();
        return i == 1;
    }

    public User findById(int id) {
        User user = new User();
        Connection c = ConnectionJDBC.getConnection();
        try {
            ResultSet res = c.createStatement().executeQuery("SELECT * FROM user WHERE id="+ id);
            while (res.next()) {
                user.setId(res.getInt("id"));
                user.setFollowers(res.getInt("followers"));
                user.setFollowers(res.getInt("followings"));
                user.setDescription(res.getString("description"));
                user.setEmail(res.getString("email"));
                user.setPhoneNumber(res.getString("phone_number"));
                user.setMention(res.getString("mention"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public ArrayList<String[]> findAll() {
        ArrayList <String[]> result = new ArrayList<>();
        Connection c = ConnectionJDBC.getConnection();
        try {
            ResultSet res = c.createStatement().executeQuery("SELECT * FROM user");
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


    public boolean create(User user)  {
        Connection c = ConnectionJDBC.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement(
                    "INSERT INTO user(followers, followings, description," +
                            "email, phone_number, mention) VALUES (?, ?, ?, ?, ?, ?)");
            if (initializeValues("create", user, ps)) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(User user)  {
        Connection c = ConnectionJDBC.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement(
                    "UPDATE user SET followers=?, followings=?," +
                            " description=?, email=?, phone_number=?, mention=? WHERE id=?");
            if (initializeValues("update",user, ps)) return true;
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
            int i = stmt.executeUpdate("DELETE FROM user WHERE id=" + id);
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