package com.kainska.service;

import com.kainska.dao.MessageDao;
import com.kainska.model.Message;

import java.util.List;

public class MessageService {

    public List<Message> findAllMessage() {
        return new MessageDao().findAll();
    }

    public Message findMessageById(int id) {
        return new MessageDao().findById(id);
    }

    public void createMessage(Message Message) {
        new MessageDao().create(Message);
    }

    public void updateMessage(Message message) {
        new MessageDao().update(message);
    }

    public void deleteMessage(Message message) {
        new MessageDao().delete(message);
    }
}
