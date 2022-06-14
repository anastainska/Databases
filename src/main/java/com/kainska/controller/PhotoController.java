package com.kainska.controller;

import com.kainska.domain.Message;
import com.kainska.domain.Photo;
import com.kainska.domain.LikePost;
import com.kainska.service.MessageService;
import com.kainska.service.PhotoService;
import com.kainska.service.LikePostService;
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

public class PhotoController {
    @Autowired
    PhotoService photoService;

    @GetMapping("/photos")
    public List<Photo> findAll() throws Exception {
        return photoService.findAll();
    }

    @GetMapping("/photos/{id}")
    public Photo findById(@PathVariable Integer id) throws Exception {
        return photoService.findById(id);
    }

    @PostMapping("/photos")
    public void create(@RequestBody Photo entity) throws Exception {
        photoService.create(entity);
    }

    @PutMapping("/photos/{id}")
    public void update(@PathVariable Integer id, @RequestBody Photo entity) throws Exception {
        entity.setId(id);
        photoService.update(entity);
    }

    @DeleteMapping("/photos/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        photoService.delete(id);
    }
}
