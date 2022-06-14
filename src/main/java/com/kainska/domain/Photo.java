package com.kainska.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "photo", schema = "kainska")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "photo", nullable = false, length = 100)
    private String photo;

    @Basic
    @Column(name = "post_id", nullable = false)
    private int postId;

    @Basic
    @Column(name = "story_id", nullable = false)
    private int storyId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getStoryId() {
        return storyId;
    }

    public void setStoryId(int storyId) {
        this.storyId = storyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo1 = (Photo) o;
        return getId() == photo1.getId() && getPhoto() == photo1.getPhoto() && getPostId() == photo1.getPostId() && getStoryId() == photo1.getStoryId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPhoto(), getPostId(), getStoryId());
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", photo=" + photo +
                ", postId=" + postId +
                ", storyId=" + storyId +
                '}';
    }
}
