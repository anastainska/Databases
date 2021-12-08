package com.kainska.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.sql.Timestamp;

@Entity
@Table(name = "like_comment", schema = "kainska")
public class LikeComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "comment_id", nullable = false)
    private int commentId;

    @Override
    public String toString() {
        return "LikeComment{" +
                "id=" + id +
                ", commentId=" + commentId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LikeComment that = (LikeComment) o;
        return getId() == that.getId() && getCommentId() == that.getCommentId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCommentId());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }
}