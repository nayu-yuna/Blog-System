package com.codeit.blogsystem.dto.post;

import java.util.List;

public record PostCreateRequestDto(
        String title,
        String content,
        List<String> tags
) { }