package com.kainska.service;

import com.kainska.dao.UserDao;
import com.kainska.model.User;

import java.util.List;

public class UserService {

    public List<User> findAllUser() {
        return new UserDao().findAll();
    }

    public User findUserById(int id) {
        return new UserDao().findById(id);
    }

    public void createUser(User user) {
        new UserDao().create(user);
    }

    public void updateUser(User user) {
        new UserDao().update(user);
    }

    public void deleteUser(User user) {
        new UserDao().delete(user);
    }
}
