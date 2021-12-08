package com.kainska.service;

import com.kainska.dao.CommentDao;
import com.kainska.model.Comment;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentService {

    public ArrayList<String[]> findAllComment() throws SQLException {
        return new CommentDao().findAll();
    }

    public Comment findCommentById(int id) {
        return new CommentDao().findById(id);
    }

    public void createComment(Comment Comment) {
        new CommentDao().create(Comment);
    }

    public void updateComment(Comment comment) {
        new CommentDao().update(comment);
    }

    public void deleteComment(Comment comment) {
        new CommentDao().delete(comment);
    }
}
