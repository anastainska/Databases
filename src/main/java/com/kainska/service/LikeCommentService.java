package com.kainska.service;

import com.kainska.dao.LikeCommentDao;
import com.kainska.model.LikeComment;

import java.util.ArrayList;

public class LikeCommentService {

    public ArrayList<String[]> findAllLikeComment() {
        return new LikeCommentDao().findAllLikeComment();
    }

    public LikeComment findLikeCommentById(int id) {
        return new LikeCommentDao().findById(id);
    }

    public void createLikeComment(LikeComment LikeComment) {
        new LikeCommentDao().create(LikeComment);
    }

    public void updateLikeComment(LikeComment likeComment) {
        new LikeCommentDao().update(likeComment);
    }

    public void deleteLikeComment(int id) {
        new LikeCommentDao().delete(id);
    }
}