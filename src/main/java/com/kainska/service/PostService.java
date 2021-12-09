package com.kainska.service;

import com.kainska.dao.PostDao;
import com.kainska.model.Post;

import java.util.ArrayList;

public class PostService {

    public ArrayList<String[]> findAllPost() {
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

    public void deletePost(int id) {
        new PostDao().delete(id);
    }
}