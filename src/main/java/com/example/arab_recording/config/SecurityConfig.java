package com.example.arab_recording.config;

import com.example.arab_recording.enums.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(final HttpSecurity http) throws Exception {
        http.csrf(CsrfConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**", "/v3/api-docs/**",
                                "/swagger-ui/**", "/swagger-ui.html",
                                "/superadmin/registration/{email}/**",
                                "/superadmin/expert_role_remove/{email}",
                                "/superadmin/account_confirm",
                                "/superadmin/add_word/**",
                                "/auth/password_reset/{email}",
                                "/auth/password_confirm",
                                "/auth/registration_confirm",
                                "/expert/{id}",
                                "/expert/report",
                                "/expert/deleteRecordedWord/{recorderWordId}",
                                "/file/upload/**",
                                "/file/delete/{fileName}",
                                "/file/download/{fileName}",
                                "/audio/**").permitAll()
                );
        return http.build();
    }
}


