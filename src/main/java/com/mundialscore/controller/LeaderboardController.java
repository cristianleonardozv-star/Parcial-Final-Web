package com.mundialscore.controller;

import com.mundialscore.dto.LeaderboardRowDto;
import com.mundialscore.service.LeaderboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaderboard")
@RequiredArgsConstructor
public class LeaderboardController {

    private final LeaderboardService leaderboardService;

    @GetMapping
    public List<LeaderboardRowDto> leaderboard() {
        return leaderboardService.leaderboard();
    }
}
