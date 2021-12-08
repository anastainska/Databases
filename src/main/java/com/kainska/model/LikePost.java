package com.kainska.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.sql.Timestamp;

@Entity
@Table(name = "like_post", schema = "kainska")
public class LikePost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "post_id", nullable = false)
    private int postId;

    @Override
    public String toString() {
        return "LikePost{" +
                "id=" + id +
                ", postId=" + postId +
                ", timeCreationLike=" + timeCreationLike +
                '}';
    }

    @Basic
    @Column(name = "time_creation_like", nullable = false)
    private Timestamp timeCreationLike;

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LikePost likePost = (LikePost) o;
        return getId() == likePost.getId() && getPostId() == likePost.getPostId() && getTimeCreationLike().equals(likePost.getTimeCreationLike());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPostId(), getTimeCreationLike());
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public Timestamp getTimeCreationLike() {
        return timeCreationLike;
    }

    public void setTimeCreationLike(Timestamp timeCreationLike) {
        this.timeCreationLike = timeCreationLike;
    }
}
