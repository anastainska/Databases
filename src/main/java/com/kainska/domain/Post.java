package com.kainska.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "post", schema = "kainska")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "text", length = 200)
    private String text;

    @Column(name = "photo", nullable = false, length = 100)
    private String photo;

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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
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
