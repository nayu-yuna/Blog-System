package com.codeit.blogsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // CORS 허용할 도메인
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable() // CSRF 비활성화
                .authorizeHttpRequests()
                .requestMatchers("/api/users/register", "/api/users/login").permitAll() // 회원가입과 로그인은 인증 없이 접근 가능
                .anyRequest().authenticated() // 나머지 API는 인증 필요
                .and()
                .formLogin().disable() // 로그인 폼 비활성화
                .httpBasic().disable(); // HTTP 기본 인증 비활성화

        return http.build();
    }
}
