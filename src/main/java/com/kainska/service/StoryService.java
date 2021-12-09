package com.kainska.service;

import com.kainska.dao.StoryDao;
import com.kainska.model.Story;

import java.util.ArrayList;

public class StoryService {

    public ArrayList<String[]> findAllStory() {
        return new StoryDao().findAll();
    }

    public Story findStoryById(int id) {
        return new StoryDao().findById(id);
    }

    public void createStory(Story Story) {
        new StoryDao().create(Story);
    }

    public void updateStory(Story story) {
        new StoryDao().update(story);
    }

    public void deleteStory(int id) {
        new StoryDao().delete(id);
    }
}