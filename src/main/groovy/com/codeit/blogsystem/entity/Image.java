package com.codeit.blogsystem.entity;

import lombok.Getter;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Getter
public class Image implements Serializable {
    private static final long serialVersionUID = 1L;

    private final UUID id;
    private final String originalName;
    private final String extension;
    private final String path;
    private final long size;
    private final Instant uploadedAt;

    public Image(String originalName, String extension, String path, long size) {
        this.id = UUID.randomUUID();
        this.originalName = originalName;
        this.extension = extension;
        this.path = path;
        this.size = size;
        this.uploadedAt = Instant.now();
    }
}
