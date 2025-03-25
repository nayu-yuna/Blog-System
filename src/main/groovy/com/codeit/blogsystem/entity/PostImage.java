package com.codeit.blogsystem.entity;

import lombok.Getter;

import java.io.Serializable;
import java.util.UUID;

@Getter
public class PostImage implements Serializable {
    private static final long serialVersionUID = 1L;

    private final UUID id;
    private final UUID postId;
    private final UUID imageId;

    public PostImage(UUID postId, UUID imageId) {
        this.id = UUID.randomUUID();
        this.postId = postId;
        this.imageId = imageId;
    }
}
