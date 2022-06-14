package com.kainska.service;

import com.kainska.Repository.PhotoRepository;
import com.kainska.Repository.PostRepository;
import com.kainska.domain.Photo;
import com.kainska.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public List<Post> findAll() throws Exception {
        List<Post> post = new LinkedList<>(postRepository.findAll());
        if (post.isEmpty()) {
            return null;
        }
        return post;
    }

    public Post findById(Integer id) throws Exception {
        if (postRepository.findById(id).isPresent()) {
            return postRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(Post entity) throws Exception {
        if (entity != null) {
            postRepository.save(entity);
        }
    }

    @Transactional
    public void update(Post post) throws Exception {
        postRepository.findById(post.getId())
                .map(oldEntity -> {
                    oldEntity.setUserId(post.getUserId());
                    oldEntity.setText(post.getText());
                    oldEntity.setPhoto(post.getPhoto());
                    oldEntity.setDatePost(post.getDatePost());
                    return postRepository.save(oldEntity);
                })
                .orElseGet(() -> postRepository.save(post));
    }

    @Transactional
    public void delete(Integer id) throws Exception {
        if (postRepository.findById(id).isPresent()) {
            postRepository.delete(findById(id));
        }
    }
}
