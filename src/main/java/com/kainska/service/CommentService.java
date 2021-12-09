package com.kainska.service;

import com.kainska.dao.CommentDao;
import com.kainska.model.Comment;

import java.util.ArrayList;

public class CommentService {

    public ArrayList<String[]> findAllComment() { return new CommentDao().findAll(); }

    public Comment findCommentById(int id) {
        return new CommentDao().findById(id);
    }

    public void createComment(Comment Comment) {
        new CommentDao().create(Comment);
    }

    public void updateComment(Comment comment) {
        new CommentDao().update(comment);
    }

    public void deleteComment(int id) {
        new CommentDao().delete(id);
    }
}