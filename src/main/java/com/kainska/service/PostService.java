package com.kainska.service;

import com.kainska.dao.PostDao;
import com.kainska.model.Post;

import java.util.List;

public class PostService {

    public List<Post> findAllPost() {
        return new PostDao().findAll();
    }

    public Post findPostById(int id) {
        return new PostDao().findById(id);
    }

    public void createPost(Post Post) {
        new PostDao().create(Post);
    }

    public void updatePost(Post post) {
        new PostDao().update(post);
    }

    public void deletePost(Post post) {
        new PostDao().delete(post);
    }
}
