package com.codeit.blogsystem.dto.user;

public record UserRegisterResponseDto(
        boolean success,
        String message
) { }