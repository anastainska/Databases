package com.kainska.controller;

import com.kainska.domain.Story;
import com.kainska.domain.Security;
import com.kainska.domain.Photo;
import com.kainska.service.StoryService;
import com.kainska.service.SecurityService;
import com.kainska.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kainska")
public class StoryController {
    @Autowired
    StoryService storyService;

    @GetMapping("/story")
    public List<Story> findAll() throws Exception {
        return storyService.findAll();
    }

    @GetMapping("/story/{id}")
    public Story findById(@PathVariable Integer id) throws Exception {
        return storyService.findById(id);
    }

    @PostMapping("/stories")
    public void create(@RequestBody Story entity) throws Exception {
        storyService.create(entity);
    }

    @PutMapping("/story/{id}")
    public void update(@PathVariable Integer id, @RequestBody Story entity) throws Exception {
        entity.setId(id);
        storyService.update(entity);
    }

    @DeleteMapping("/story/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        storyService.delete(id);
    }
}
