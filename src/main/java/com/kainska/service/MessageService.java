package com.kainska.service;

import com.kainska.dao.MessageDao;
import com.kainska.model.Message;

import java.util.ArrayList;

public class MessageService {

    public ArrayList<String[]> findAllMessage() {
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

    public void deleteMessage(int id) {
        new MessageDao().delete(id);
    }
}