package com.sight.boardapi.application.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@ConditionalOnDefaultWebSecurity
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
@RequiredArgsConstructor
public class SecurityConfig {

  private final CustomOAuth2UserService customOAuth2UserService;

  @Bean
  @Order(SecurityProperties.BASIC_AUTH_ORDER)
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .headers().frameOptions().disable()
        .and()

        .authorizeHttpRequests()
        .requestMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
        .requestMatchers("/api/v1/**").hasRole(/*Role.USER.name()*/"")
        .anyRequest().authenticated()

        .and()
        .logout()
        .logoutSuccessUrl("/")

        .and()
        .oauth2Login()
        .userInfoEndpoint()
        .userService(customOAuth2UserService);

    return http.build();
  }

}
