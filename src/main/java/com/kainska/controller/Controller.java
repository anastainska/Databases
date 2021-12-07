package com.kainska.controller;

import com.kainska.dao.*;
import com.kainska.model.*;
import com.kainska.service.*;

import java.util.List;

public class Controller {

    private UserService userService;

    public Controller() {
        userService = new UserService();
    }

    public User findUserById(Integer id) { return userService.findUserById(id); }

    public List<User> findAllUser() { return userService.findAllUser(); }

    public void createUser(User user) { userService.createUser(user); }

    public void updateUser(User user) { userService.updateUser(user); }

    public void deleteUser(User user) { userService.deleteUser(user); }

}
