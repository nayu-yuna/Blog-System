package com.codeit.blogsystem.entity;

import lombok.Getter;

import java.io.Serializable;
import java.time.Instant;

@Getter
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String id;
    private final String password;
    private final String userEmail;
    private final String nickname;
    private final Instant createdAt;

    public User(String id, String password, String userEmail, String nickname) {
        this.id = id;
        this.password = password;
        this.userEmail = userEmail;
        this.nickname = nickname;
        this.createdAt = Instant.now();
    }
}