package com.kainska.service;

import com.kainska.dao.LikePostDao;
import com.kainska.model.LikePost;

import java.util.List;

public class LikePostService {

    public List<LikePost> findAllLikePost() {
        return new LikePostDao().findAll();
    }

    public LikePost findLikePostById(int id) {
        return new LikePostDao().findById(id);
    }

    public void createLikePost(LikePost LikePost) {
        new LikePostDao().create(LikePost);
    }

    public void updateLikePost(LikePost likePost) {
        new LikePostDao().update(likePost);
    }

    public void deleteLikePost(LikePost likePost) {
        new LikePostDao().delete(likePost);
    }
}
