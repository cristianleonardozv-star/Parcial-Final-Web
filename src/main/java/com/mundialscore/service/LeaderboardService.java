package com.mundialscore.service;

import com.mundialscore.dto.LeaderboardRowDto;
import com.mundialscore.repository.PredictionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeaderboardService {

    private final PredictionRepository predictionRepository;

    public List<LeaderboardRowDto> leaderboard() {
        return predictionRepository.leaderboard()
                .stream()
                .map(r -> LeaderboardRowDto.builder()
                        .username(r.getUsername())
                        .totalPoints(r.getTotalPoints() == null ? 0 : r.getTotalPoints())
                        .build())
                .toList();
    }
}
