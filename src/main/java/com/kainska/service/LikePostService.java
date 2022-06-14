package com.kainska.service;

import com.kainska.Repository.LikePostRepository;
import com.kainska.domain.Comment;
import com.kainska.domain.LikeComment;
import com.kainska.domain.LikePost;
import com.kainska.Repository.LikeCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class LikePostService {
    @Autowired
    LikePostRepository likePostRepository;

    public List<LikePost> findAll() throws Exception {
        List<LikePost> likePosts = new LinkedList<>(likePostRepository.findAll());
        if (likePosts.isEmpty()) {
            return null;
        }
        return likePosts;
    }

    public LikePost findById(Integer id) throws Exception {
        if (likePostRepository.findById(id).isPresent()) {
            return likePostRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(LikePost entity) throws Exception {
        if (entity != null) {
            likePostRepository.save(entity);
        }
    }

    @Transactional
    public void update(LikePost likePost) throws Exception {
        likePostRepository.findById(likePost.getId())
                .map(oldEntity -> {
                    oldEntity.setTimeCreationLike(likePost.getTimeCreationLike());
                    oldEntity.setPostId(likePost.getPostId());
                    return likePostRepository.save(oldEntity);
                })
                .orElseGet(() -> likePostRepository.save(likePost));
    }

    @Transactional
    public void delete(Integer id) throws Exception {
        if (likePostRepository.findById(id).isPresent()) {
            likePostRepository.delete(findById(id));
        }
    }
}

