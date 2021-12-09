package com.kainska.service;

import com.kainska.dao.LikePostDao;
import com.kainska.model.LikePost;

import java.util.ArrayList;

public class LikePostService {

    public ArrayList<String[]> findAllLikePost() {
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

    public void deleteLikePost(int id) {
        new LikePostDao().delete(id);
    }
}