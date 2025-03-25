package com.codeit.blogsystem.controller;

import com.codeit.blogsystem.dto.user.UserLoginRequestDto;
import com.codeit.blogsystem.dto.user.UserLoginResponseDto;
import com.codeit.blogsystem.dto.user.UserRegisterRequestDto;
import com.codeit.blogsystem.dto.user.UserRegisterResponseDto;
import com.codeit.blogsystem.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 회원가입 API
    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDto> register(@Valid @RequestBody UserRegisterRequestDto userRegisterRequestDto) {
        userService.register(userRegisterRequestDto);
        UserRegisterResponseDto response = new UserRegisterResponseDto(true, "회원 가입이 완료되었습니다.");
        return ResponseEntity.ok(response);
    }

    // 로그인 API
    @PostMapping("/login")
    public ResponseEntity<UserLoginResponseDto> login(@Valid @RequestBody UserLoginRequestDto userLoginRequestDto) {
        String token = userService.login(userLoginRequestDto);
        UserLoginResponseDto response = new UserLoginResponseDto(true, token);
        return ResponseEntity.ok(response);
    }

    // 아이디 존재 여부 확인 API
    @GetMapping("/exists/{id}")
    public ResponseEntity<String> checkUserExistence(@PathVariable String id) {
        boolean exists = userService.existsById(id);
        if (exists) {
            return ResponseEntity.ok("아이디가 존재합니다.");
        } else {
            return ResponseEntity.ok("아이디가 존재하지 않습니다.");
        }
    }
}
