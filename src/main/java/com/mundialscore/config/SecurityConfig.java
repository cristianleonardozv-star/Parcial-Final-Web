package com.mundialscore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable());

        http.authorizeHttpRequests(auth -> auth
                // Swagger abierto
                .requestMatchers("/swagger/**", "/swagger-ui/**", "/v3/api-docs/**", "/api-docs/**").permitAll()

                // Static resources (HTML, CSS, JS, Images)
                .requestMatchers("/", "/*.html", "/css/**", "/js/**", "/images/**", "/favicon.ico").permitAll()

                // Registro abierto
                .requestMatchers(HttpMethod.POST, "/api/auth/register").permitAll()

                // Lectura de partidos: USER o ADMIN
                .requestMatchers(HttpMethod.GET, "/api/matches/**").hasAnyRole("USER", "ADMIN")

                // USER: apuestas, resultados
                .requestMatchers("/api/predictions/**").hasRole("USER")

                // Tabla general: USER o ADMIN
                .requestMatchers(HttpMethod.GET, "/api/leaderboard/**").hasAnyRole("USER", "ADMIN")

                // ADMIN: resultados reales
                .requestMatchers("/api/admin/**").hasRole("ADMIN")

                // Cualquier otra cosa autenticada
                .anyRequest().authenticated());

        // Basic Auth para usar fácil en Swagger
        http.httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
