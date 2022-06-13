package com.sportyshoes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.antMatcher("/")
                .authorizeRequests()
                .anyRequest().hasRole("admin")
                .and()
                .httpBasic();

        http.headers().frameOptions().sameOrigin();
        return http.build();

    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {

        PasswordEncoder passwordEncoder =PasswordEncoderFactories.createDelegatingPasswordEncoder();

        UserDetails user = User.withUsername("Tarun")
                .password(passwordEncoder.encode("pwd"))
                .roles("admin").build();

        return new InMemoryUserDetailsManager(user);

    }
}
