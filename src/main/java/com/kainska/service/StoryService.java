package com.kainska.service;

import com.kainska.Repository.StoryRepository;
import com.kainska.Repository.SecurityRepository;
import com.kainska.domain.Story;
import com.kainska.domain.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class StoryService {
    @Autowired
    StoryRepository storyRepository;

    public List<Story> findAll() throws Exception {
        List<Story> story = new LinkedList<>(storyRepository.findAll());
        if (story.isEmpty()) {
            return null;
        }
        return story;
    }

    public Story findById(Integer id) throws Exception {
        if (storyRepository.findById(id).isPresent()) {
            return storyRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(Story entity) throws Exception {
        if (entity != null) {
            storyRepository.save(entity);
        }
    }

    @Transactional
    public void update(Story story) throws Exception {
        storyRepository.findById(story.getId())
                .map(oldEntity -> {
                    oldEntity.setReactions(story.getReactions());
                    oldEntity.setUserId(story.getUserId());
                    return storyRepository.save(oldEntity);
                })
                .orElseGet(() -> storyRepository.save(story));
    }

    @Transactional
    public void delete(Integer id) throws Exception {
        if (storyRepository.findById(id).isPresent()) {
            storyRepository.delete(findById(id));
        }
    }
}
