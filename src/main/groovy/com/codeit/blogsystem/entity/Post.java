package com.codeit.blogsystem.entity;

import lombok.Getter;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Getter
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;

    private final UUID id;
    private String title;
    private String content;
    private final String authorId;
    private List<String> tags;
    private final Instant createdAt;
    private Instant updatedAt;

    public Post(String title, String content, String authorId, List<String> tags, Instant updatedAt) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.tags = tags;
        this.createdAt = Instant.now();
        this.updatedAt = this.createdAt;
    }

    public void update(String newTitle, String newContent, List<String> newTags) {
        boolean anyValueUpdated = false;
        if (newTitle != null && !newTitle.equals(this.title)) {
            this.title = newTitle;
            anyValueUpdated = true;
        }
        if (newContent != null && !newContent.equals(this.content)) {
            this.content = newContent;
            anyValueUpdated = true;
        }
        if (newTags != null && !newTags.equals(this.tags)) {
            this.tags = newTags;
            anyValueUpdated = true;
        }
        if (anyValueUpdated) {
            this.updatedAt = Instant.now();
        }
    }
}