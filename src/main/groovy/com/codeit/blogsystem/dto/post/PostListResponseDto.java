package com.codeit.blogsystem.dto.post;

import java.util.List;

public record PostListResponseDto(
        List<PostDto> posts,
        int totalPages,
        int currentPage
) { }

