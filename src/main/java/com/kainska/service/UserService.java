package com.kainska.service;

import com.kainska.dao.UserDao;
import com.kainska.model.User;

import java.util.ArrayList;

public class UserService {

    public ArrayList<String[]> findAllUser() { return new UserDao().findAll(); }

    public User findUserById(int id) { return new UserDao().findById(id); }

    public void createUser(User user) { new UserDao().create(user); }

    public void updateUser(User user) {
        new UserDao().update(user);
    }

    public void deleteUser(int id) {
        new UserDao().delete(id);
    }
}