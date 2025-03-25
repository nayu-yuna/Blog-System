package com.codeit.blogsystem.dto.post;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record PostDto(
        UUID id,
        String title,
        String content,
        String authorId,
        String authorNickname,
        Instant createdAt,
        List<String> tags
) { }