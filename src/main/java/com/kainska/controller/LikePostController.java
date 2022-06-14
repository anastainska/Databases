package com.kainska.controller;

import com.kainska.domain.LikeComment;
import com.kainska.domain.LikePost;
import com.kainska.service.LikeCommentService;
import com.kainska.service.LikePostService;
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
public class LikePostController {
    @Autowired
    LikePostService likePostService;

    @GetMapping("/like_posts")
    public List<LikePost> findAll() throws Exception {
        return likePostService.findAll();
    }

    @GetMapping("/like_posts/{id}")
    public LikePost findById(@PathVariable Integer id) throws Exception {
        return likePostService.findById(id);
    }

    @PostMapping("/like_posts")
    public void create(@RequestBody LikePost entity) throws Exception {
        likePostService.create(entity);
    }

    @PutMapping("/like_posts/{id}")
    public void update(@PathVariable Integer id, @RequestBody LikePost entity) throws Exception {
        entity.setId(id);
        likePostService.update(entity);
    }

    @DeleteMapping("/like_posts/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        likePostService.delete(id);
    }

}
