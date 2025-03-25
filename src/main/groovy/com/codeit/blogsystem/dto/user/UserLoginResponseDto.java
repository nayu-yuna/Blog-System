package com.codeit.blogsystem.dto.user;

public record UserLoginResponseDto(
        boolean success,
        String token
) { }
