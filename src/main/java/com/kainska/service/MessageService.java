package com.kainska.service;

import com.kainska.Repository.MessageRepository;
import com.kainska.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    public List<Message> findAll() throws Exception {
        List<Message> messages = new LinkedList<>(messageRepository.findAll());
        if (messages.isEmpty()) {
            return null;
        }
        return messages;
    }

    public Message findById(Integer id) throws Exception {
        if (messageRepository.findById(id).isPresent()) {
            return messageRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(Message entity) throws Exception {
        if (entity != null) {
            messageRepository.save(entity);
        }
    }

    @Transactional
    public void update(Message message) throws Exception {
        messageRepository.findById(message.getId())
                .map(oldEntity -> {
                    oldEntity.setTextMessage(message.getTextMessage());
                    oldEntity.setTimeCreation(message.getTimeCreation());
                    oldEntity.setTimeSeen(message.getTimeSeen());
                    oldEntity.setUserId(message.getUserId());
                    return messageRepository.save(oldEntity);
                })
                .orElseGet(() -> messageRepository.save(message));
    }

    @Transactional
    public void delete(Integer id) throws Exception {
        if (messageRepository.findById(id).isPresent()) {
            messageRepository.delete(findById(id));
        }
    }
}
