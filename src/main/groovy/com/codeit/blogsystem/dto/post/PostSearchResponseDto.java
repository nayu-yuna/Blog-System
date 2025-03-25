package com.codeit.blogsystem.dto.post;

import java.util.List;

public record PostSearchResponseDto(
        List<PostDto> posts,
        int totalPages,
        int currentPage,
        String keyword
) { }
