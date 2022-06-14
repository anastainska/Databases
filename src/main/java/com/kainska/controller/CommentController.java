package com.kainska.controller;


import com.kainska.domain.Comment;
import com.kainska.service.CommentService;
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
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("/comments")
    public List<Comment> findAll() throws Exception {
        return commentService.findAll();
    }

    @GetMapping("/comments/{id}")
    public Comment findById(@PathVariable Integer id) throws Exception {
        return commentService.findById(id);
    }

    @PostMapping("/comments")
    public void create(@RequestBody Comment entity) throws Exception {
        commentService.create(entity);
    }

    @PutMapping("/comments/{id}")
    public void update(@PathVariable Integer id, @RequestBody Comment entity) throws Exception {
        entity.setId(id);
        commentService.update(entity);
    }

    @DeleteMapping("/comments/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        commentService.delete(id);
    }
}