package com.codeit.blogsystem.repository;

import com.codeit.blogsystem.entity.User;

import java.util.Optional;

public interface UserRepository {
    void save(User user);
    Optional<User> findById(String id);
    boolean existsById(String id);
}