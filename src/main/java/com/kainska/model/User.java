package com.kainska.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "kainska")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "followers")
    private int followers;

    @Basic
    @Column(name = "followings")
    private int followings;

    @Basic
    @Column(name = "description", length = 45)
    private String description;

    @Basic
    @Column(name = "email", length = 45, nullable = false)
    private String email;

    @Basic
    @Column(name = "phone_number", length = 45, nullable = false)
    private String phoneNumber;

    @Basic
    @Column(name = "mention", length = 45)
    private String mention;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowings() {
        return followings;
    }

    public void setFollowings(int followings) {
        this.followings = followings;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMention() {
        return mention;
    }

    public void setMention(String mention) {
        this.mention = mention;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getId() == user.getId() && getFollowers() == user.getFollowers()
                && getFollowings() == user.getFollowings() && Objects.equals(getDescription(),
                user.getDescription()) && getEmail().equals(user.getEmail())
                && getPhoneNumber().equals(user.getPhoneNumber())
                && Objects.equals(getMention(), user.getMention());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFollowers(), getFollowings(),
                getDescription(), getEmail(), getPhoneNumber(), getMention());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", followers=" + followers +
                ", followings=" + followings +
                ", description='" + description + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", mention='" + mention + '\'' +
                '}';
    }
}
