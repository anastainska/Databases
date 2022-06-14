package com.kainska.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "security", schema = "kainska")
public class Security {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "nickname", nullable = false, length = 45)
    private String nickname;

    @Column(name = "password", nullable = false, length = 45)
    private String password;

    @Column(name = "user_id", nullable = false)
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        Security security = (Security) o;
        return getId() == security.getId() && getUserId() == security.getUserId() && getNickname().equals(security.getNickname()) && getPassword().equals(security.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNickname(), getPassword(), getUserId());
    }

    @Override
    public String toString() {
        return "Security{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", userId=" + userId +
                '}';
    }
}
