package com.kainska.dao;

import com.kainska.model.Photo;
import com.kainska.utils.ConnectionJDBC;

import java.sql.*;
import java.util.ArrayList;

public class PhotoDao {

    public PhotoDao() {
    }

    private boolean initializeValues(String method, Photo photo, PreparedStatement ps) throws SQLException  {
        if (method.equals("update")) {
            ps.setInt(4, photo.getId());
            ps.setByte(1, photo.getPhoto());
            ps.setInt(2, photo.getPostId());
            ps.setInt(3, photo.getStoryId());
        } else if (method.equals("create")) {
            ps.setInt(4, photo.getId());
            ps.setByte(1, photo.getPhoto());
            ps.setInt(2, photo.getPostId());
            ps.setInt(3, photo.getStoryId());
        }
        int i = ps.executeUpdate();
        return i == 1;
    }

    public Photo findById(int id) {
        Photo photo = new Photo();
        Connection c = ConnectionJDBC.getConnection();
        try {
            ResultSet res = c.createStatement().executeQuery("SELECT * FROM photo WHERE id="+ id);
            while (res.next()) {
                photo.setId(res.getInt("id"));
                photo.setPhoto(res.getByte("photo"));
                photo.setPostId(res.getInt("post_id"));
                photo.setStoryId(res.getInt("story_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return photo;
    }

    public ArrayList<String[]> findAll() {
        ArrayList <String[]> result = new ArrayList<>();
        Connection c = ConnectionJDBC.getConnection();
        try {
            ResultSet res = c.createStatement().executeQuery("SELECT * FROM photo");
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


    public boolean create(Photo photo) {
        Connection c = ConnectionJDBC.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement(
                    "INSERT INTO photo VALUES (NULL, ?, ?, ?, ?, ?)");
            if (initializeValues("create", photo, ps)) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Photo photo) {
        Connection c = ConnectionJDBC.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement(
                    "UPDATE photo SET photo=?, post_id=?," +
                            " story_id=? WHERE id=?");
            if (initializeValues("update", photo, ps)) return true;
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
            int i = stmt.executeUpdate("DELETE FROM photo WHERE id=" + id);
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