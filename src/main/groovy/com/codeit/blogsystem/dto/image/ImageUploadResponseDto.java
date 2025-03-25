package com.codeit.blogsystem.dto.image;

import java.util.UUID;

public record ImageUploadResponseDto(
        boolean success,
        UUID imageId,
        String path
) { }