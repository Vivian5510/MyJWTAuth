package com.rosy.myjwtauth.config;

import com.rosy.myjwtauth.filter.JwtAuthenticationProcessFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    @Autowired
    JwtAuthenticationProcessFilter jwtAuthenticationProcessFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*这是Spring-Security6.x之后，将AuthenticationManager注入容器的方法。其中AuthenticationConfiguration是Spring提供的一个配置类*/
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // 禁用 CSRF 保护
                .sessionManagement(sessionManagement ->
                        sessionManagement
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)  // 配置为无状态会话
                )
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/user/login").anonymous()
                        .requestMatchers("/public/**").permitAll() // 公共资源无需认证
                        .anyRequest().authenticated()             // 其他请求需认证
                )
                .addFilterBefore(jwtAuthenticationProcessFilter, UsernamePasswordAuthenticationFilter.class);


        return http.build();
    }
}
