package com.codeit.blogsystem.service.impl;

import com.codeit.blogsystem.dto.user.UserLoginRequestDto;
import com.codeit.blogsystem.entity.User;
import com.codeit.blogsystem.repository.UserRepository;
import com.codeit.blogsystem.security.JwtUtil;
import com.codeit.blogsystem.service.UserService;
import com.codeit.blogsystem.dto.user.UserRegisterRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Override
    public void register(@Valid UserRegisterRequestDto userRegisterRequestDto) {
        String id = userRegisterRequestDto.id();

        if (userRepository.existsById(id)) {
            throw new IllegalArgumentException("이미 사용중인 아이디입니다.");
        }

        String password = BCrypt.hashpw(userRegisterRequestDto.password(), BCrypt.gensalt());

        User user = new User(
                id,
                password,
                userRegisterRequestDto.userEmail(),
                userRegisterRequestDto.nickname()
        );

        userRepository.save(user);
    }

    @Override
    public String login(UserLoginRequestDto userLoginRequestDto) {
        User user = userRepository.findById(userLoginRequestDto.id())
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

        if (!BCrypt.checkpw(userLoginRequestDto.password(), user.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }

        return jwtUtil.generateToken(user.getId());
    }

    @Override
    public boolean existsById(String id) {
        return userRepository.existsById(id);
    }
}
