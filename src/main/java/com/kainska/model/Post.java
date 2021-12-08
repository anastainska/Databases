package com.kainska.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.sql.Timestamp;

@Entity
@Table(name = "post", schema = "kainska")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "user_id", nullable = false)
    private int userId;

    @Basic
    @Column(name = "text", length = 200)
    private String text;

    @Basic
    @Column(name = "photo", nullable = false, length = 100)
    private byte photo;

    @Basic
    @Column(name = "date_post", nullable = false)
    private Timestamp datePost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public byte getPhoto() {
        return photo;
    }

    public void setPhoto(byte photo) {
        this.photo = photo;
    }

    public Timestamp getDatePost() {
        return datePost;
    }

    public void setDatePost(Timestamp datePost) {
        this.datePost = datePost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return getId() == post.getId() && getUserId() == post.getUserId() && getPhoto() == post.getPhoto() && getText().equals(post.getText()) && getDatePost().equals(post.getDatePost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserId(), getText(), getPhoto(), getDatePost());
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", userId=" + userId +
                ", text='" + text + '\'' +
                ", photo=" + photo +
                ", datePost=" + datePost +
                '}';
    }
}
