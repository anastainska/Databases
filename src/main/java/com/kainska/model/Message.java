package com.kainska.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.sql.Timestamp;

@Entity
@Table(name = "message", schema = "kainska")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "text_message", length = 45)
    private String textMessage;

    @Basic
    @Column(name = "time_creation", nullable = false)
    private Timestamp timeCreation;

    @Basic
    @Column(name = "time_seen", nullable = false)
    private Timestamp timeSeen;

    @Basic
    @Column(name = "user_id", nullable = false)
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public Timestamp getTimeCreation() {
        return timeCreation;
    }

    public void setTimeCreation(Timestamp timeCreation) {
        this.timeCreation = timeCreation;
    }

    public Timestamp getTimeSeen() {
        return timeSeen;
    }

    public void setTimeSeen(Timestamp timeSeen) {
        this.timeSeen = timeSeen;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return getId() == message.getId() && getUserId() == message.getUserId() && getTextMessage().equals(message.getTextMessage()) && getTimeCreation().equals(message.getTimeCreation()) && getTimeSeen().equals(message.getTimeSeen());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTextMessage(), getTimeCreation(), getTimeSeen(), getUserId());
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", textMessage='" + textMessage + '\'' +
                ", timeCreation=" + timeCreation +
                ", timeSeen=" + timeSeen +
                ", userId=" + userId +
                '}';
    }
}
