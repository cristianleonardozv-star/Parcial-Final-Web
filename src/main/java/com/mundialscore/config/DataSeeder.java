package com.mundialscore.config;

import com.mundialscore.entity.Match;
import com.mundialscore.entity.Role;
import com.mundialscore.entity.User;
import com.mundialscore.repository.MatchRepository;
import com.mundialscore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final MatchRepository matchRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        // Admin por defecto
        if (!userRepository.existsByUsername("admin")) {
            User admin = User.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("admin123"))
                    .roles(Set.of(Role.ROLE_ADMIN))
                    .build();
            userRepository.save(admin);
        }

        // Partidos demo (si no hay)
        if (matchRepository.count() == 0) {
            matchRepository.save(Match.builder()
                    .homeTeam("Colombia")
                    .awayTeam("Argentina")
                    .matchDate(LocalDateTime.now().plusDays(1))
                    .finished(false)
                    .build());

            matchRepository.save(Match.builder()
                    .homeTeam("Brasil")
                    .awayTeam("Uruguay")
                    .matchDate(LocalDateTime.now().plusDays(2))
                    .finished(false)
                    .build());
        }
    }
}
