package com.kainska.service;

import com.kainska.Repository.StoryRepository;
import com.kainska.Repository.UserRepository;
import com.kainska.Repository.SecurityRepository;
import com.kainska.domain.Story;
import com.kainska.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> findAll() throws Exception {
        List<User> user = new LinkedList<>(userRepository.findAll());
        if (user.isEmpty()) {
            return null;
        }
        return user;
    }

    public User findById(Integer id) throws Exception {
        if (userRepository.findById(id).isPresent()) {
            return userRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(User entity) throws Exception {
        if (entity != null) {
            userRepository.save(entity);
        }
    }

    @Transactional
    public void update(User user) throws Exception {
        userRepository.findById(user.getId())
                .map(oldEntity -> {
                    oldEntity.setFollowers(user.getFollowers());
                    oldEntity.setFollowings(user.getFollowings());
                    oldEntity.setDescription(user.getDescription());
                    oldEntity.setEmail(user.getEmail());
                    oldEntity.setPhoneNumber(user.getPhoneNumber());
                    oldEntity.setMention(user.getMention());
                    return userRepository.save(oldEntity);
                })
                .orElseGet(() -> userRepository.save(user));
    }

    @Transactional
    public void delete(Integer id) throws Exception {
        if (userRepository.findById(id).isPresent()) {
            userRepository.delete(findById(id));
        }
    }
}
