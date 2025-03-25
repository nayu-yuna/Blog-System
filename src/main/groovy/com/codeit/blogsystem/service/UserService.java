package com.codeit.blogsystem.service;

import com.codeit.blogsystem.dto.user.UserLoginRequestDto;
import com.codeit.blogsystem.dto.user.UserRegisterRequestDto;

public interface UserService {
    void register(UserRegisterRequestDto signUpRequestDto);  // 회원 가입
    String login(UserLoginRequestDto userLoginRequestDto);  // 로그인
    boolean existsById(String id);  // 사용자 존재 여부 확인
}
