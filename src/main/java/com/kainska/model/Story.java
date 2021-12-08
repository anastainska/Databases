package com.kainska.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.sql.Timestamp;

@Entity
@Table(name = "story", schema = "kainska")
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "reactions", length = 50)
    private String reactions;

    @Basic
    @Column(name = "user_iduser", nullable = false)
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReactions() {
        return reactions;
    }

    public void setReactions(String reactions) {
        this.reactions = reactions;
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
        Story story = (Story) o;
        return getId() == story.getId() && getUserId() == story.getUserId() && getReactions().equals(story.getReactions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getReactions(), getUserId());
    }

    @Override
    public String toString() {
        return "Story{" +
                "id=" + id +
                ", reactions='" + reactions + '\'' +
                ", userId=" + userId +
                '}';
    }
}
