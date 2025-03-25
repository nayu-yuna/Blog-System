package com.codeit.blogsystem.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserRegisterRequestDto(
        @NotBlank(message = "아이디는 필수 입력 항목입니다.")
        @Size(min = 6, max = 30, message = "아이디는 6자 이상 30자 이하로 입력해주세요.")
        String id,

        @NotBlank(message = "비밀번호는 필수 입력 항목입니다.")
        @Pattern(regexp = "^(?=(.*[a-zA-Z]){2,})(?=(.*\\d){2,})(?=(.*[!@#$%^&*]){2,}).{12,50}$",
                message = "비밀번호는 12자 이상 50자 이하로 영문자 2개 이상, 숫자 2개 이상, 특수문자 2개 이상 포함해야 합니다.")
        String password,

        @NotBlank(message = "이메일은 필수 입력 항목입니다.")
        @Email(message = "이메일 형식이 올바르지 않습니다.")
        @Size(max = 100, message = "이메일은 100자 이하로 입력해주세요.")
        String userEmail,

        @NotBlank(message = "닉네임은 필수 입력 항목입니다.")
        @Size(min = 3, max = 50, message = "닉네임은 3자 이상 50자 이하로 입력해주세요.")
        String nickname
) { }