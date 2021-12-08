package com.kainska.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.sql.Timestamp;

@Entity
@Table(name = "comment", schema = "kainska")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "text", length = 50)
    private String text;

    @Basic
    @Column(name = "post_id", nullable = false)
    private int postId;

    @Basic
    @Column(name = "date_comment", nullable = false)
    private Timestamp dateComment;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", postId=" + postId +
                ", dateComment=" + dateComment +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return getId() == comment.getId() && getPostId() == comment.getPostId() && getText().equals(comment.getText()) && getDateComment().equals(comment.getDateComment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getText(), getPostId(), getDateComment());
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public int getPostId() {
        return postId;
    }

    public Timestamp getDateComment() {
        return dateComment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public void setDateComment(Timestamp dateComment) {
        this.dateComment = dateComment;
    }
}
