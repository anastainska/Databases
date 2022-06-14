package com.kainska.service;

import com.kainska.Repository.CommentRepository;
import com.kainska.domain.Comment;
import com.kainska.domain.LikeComment;
import com.kainska.Repository.LikeCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class LikeCommentService {
    @Autowired
    LikeCommentRepository likeCommentRepository;

    public List<LikeComment> findAll() throws Exception {
        List<LikeComment> likeComments = new LinkedList<>(likeCommentRepository.findAll());
        if (likeComments.isEmpty()) {
            return null;
        }
        return likeComments;
    }

    public LikeComment findById(Integer id) throws Exception {
        if (likeCommentRepository.findById(id).isPresent()) {
            return likeCommentRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(LikeComment entity) throws Exception {
        if (entity != null) {
            likeCommentRepository.save(entity);
        }
    }

    @Transactional
    public void update(LikeComment likeComment) throws Exception {
        likeCommentRepository.findById(likeComment.getId())
                .map(oldEntity -> {
                    oldEntity.setCommentId(likeComment.getCommentId());
                    return likeCommentRepository.save(oldEntity);
                })
                .orElseGet(() -> likeCommentRepository.save(likeComment));
    }

    @Transactional
    public void delete(Integer id) throws Exception {
        if (likeCommentRepository.findById(id).isPresent()) {
            likeCommentRepository.delete(findById(id));
        }
    }
}
