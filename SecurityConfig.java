package org.example.taskbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(Customizer.withDefaults()) // CORS設定を有効化
                .csrf(csrf -> csrf.disable())    // REST API用にCSRFを無効化
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll() // ★ すべてのOPTIONSリクエスト（事前リクエスト）を許可
                        .requestMatchers("/api/login", "/api/register").permitAll() // 必要に応じて認証なしで通すエンドポイント
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}