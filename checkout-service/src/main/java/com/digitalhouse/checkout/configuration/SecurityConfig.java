package com.digitalhouse.checkout.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(
                        auth -> auth
                                .requestMatchers("/checkout/{id}").hasAuthority("SCOPE_email")
                                .anyRequest().authenticated() // Require authentication for all requests
                )
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt
                                .jwkSetUri("http://localhost:8080/realms/dh/protocol/openid-connect/certs"))
                );
        return http.build();
    }
}
