package com.kainska.controller;

import com.kainska.domain.Message;
import com.kainska.domain.LikePost;
import com.kainska.service.MessageService;
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
public class MessageController {
    @Autowired
    MessageService messageService;

    @GetMapping("/messages")
    public List<Message> findAll() throws Exception {
        return messageService.findAll();
    }

    @GetMapping("/messages/{id}")
    public Message findById(@PathVariable Integer id) throws Exception {
        return messageService.findById(id);
    }

    @PostMapping("/messages")
    public void create(@RequestBody Message entity) throws Exception {
        messageService.create(entity);
    }

    @PutMapping("/messages/{id}")
    public void update(@PathVariable Integer id, @RequestBody Message entity) throws Exception {
        entity.setId(id);
        messageService.update(entity);
    }

    @DeleteMapping("/messages/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        messageService.delete(id);
    }

}
