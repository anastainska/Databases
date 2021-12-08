package com.kainska.service;

import com.kainska.dao.LikeCommentDao;
import com.kainska.model.LikeComment;

import java.util.List;

public class LikeCommentService {

    public List<LikeComment> findAllLikeComment() {
        return new LikeCommentDao().findAll();
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

    public void deleteLikeComment(LikeComment likeComment) {
        new LikeCommentDao().delete(likeComment);
    }
}
