package com.kainska.service;

import com.kainska.domain.Comment;
import com.kainska.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    public List<Comment> findAll() throws Exception {
        List<Comment> comments = new LinkedList<>(commentRepository.findAll());
        if (comments.isEmpty()) {
            return null;
        }
        return comments;
    }

    public Comment findById(Integer id) throws Exception {
        if (commentRepository.findById(id).isPresent()) {
            return commentRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(Comment entity) throws Exception {
        if (entity != null) {
            commentRepository.save(entity);
        }
    }

    @Transactional
    public void update(Comment comment) throws Exception {
        commentRepository.findById(comment.getId())
                .map(oldEntity -> {
                    oldEntity.setText(comment.getText());
                    oldEntity.setPostId(comment.getPostId());
                    oldEntity.setDateComment(comment.getDateComment());
                    return commentRepository.save(oldEntity);
                })
                .orElseGet(() -> commentRepository.save(comment));
    }

    @Transactional
    public void delete(Integer id) throws Exception {
        if (commentRepository.findById(id).isPresent()) {
            commentRepository.delete(findById(id));
        }
    }
}
