package com.kainska.controller;

import com.kainska.domain.Story;
import com.kainska.domain.User;
import com.kainska.domain.Security;
import com.kainska.domain.Photo;
import com.kainska.service.StoryService;
import com.kainska.service.UserService;
import com.kainska.service.SecurityService;
import com.kainska.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kainska")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user")
    public List<User> findAll() throws Exception {
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Integer id) throws Exception {
        return userService.findById(id);
    }

    @PostMapping("/users")
    public void create(@RequestBody User entity) throws Exception {
        userService.create(entity);
    }

    @PutMapping("/user/{id}")
    public void update(@PathVariable Integer id, @RequestBody User entity) throws Exception {
        entity.setId(id);
        userService.update(entity);
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        userService.delete(id);
    }
}
