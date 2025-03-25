package com.codeit.blogsystem.dto.post;

import java.util.UUID;

public record PostCreateResponseDto(
        boolean success,
        UUID postId
) { }