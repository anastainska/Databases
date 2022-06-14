package com.kainska.controller;


import com.kainska.domain.LikeComment;
import com.kainska.service.LikeCommentService;
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
public class LikeCommentController {
    @Autowired
    LikeCommentService likeCommentService;

    @GetMapping("/like_comments")
    public List<LikeComment> findAll() throws Exception {
        return likeCommentService.findAll();
    }

    @GetMapping("/like_comments/{id}")
    public LikeComment findById(@PathVariable Integer id) throws Exception {
        return likeCommentService.findById(id);
    }

    @PostMapping("/like_comments")
    public void create(@RequestBody LikeComment entity) throws Exception {
        likeCommentService.create(entity);
    }

    @PutMapping("/like_comments/{id}")
    public void update(@PathVariable Integer id, @RequestBody LikeComment entity) throws Exception {
        entity.setId(id);
        likeCommentService.update(entity);
    }

    @DeleteMapping("/like_comments/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        likeCommentService.delete(id);
    }
}