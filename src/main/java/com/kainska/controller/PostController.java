package com.kainska.controller;

import com.kainska.domain.Post;
import com.kainska.domain.Photo;
import com.kainska.service.PostService;
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
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("/posts")
    public List<Post> findAll() throws Exception {
        return postService.findAll();
    }

    @GetMapping("/posts/{id}")
    public Post findById(@PathVariable Integer id) throws Exception {
        return postService.findById(id);
    }

    @PostMapping("/posts")
    public void create(@RequestBody Post entity) throws Exception {
        postService.create(entity);
    }

    @PutMapping("/posts/{id}")
    public void update(@PathVariable Integer id, @RequestBody Post entity) throws Exception {
        entity.setId(id);
        postService.update(entity);
    }

    @DeleteMapping("/posts/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        postService.delete(id);
    }
}
