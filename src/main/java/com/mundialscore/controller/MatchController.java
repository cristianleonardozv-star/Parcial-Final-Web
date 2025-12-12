package com.mundialscore.controller;

import com.mundialscore.dto.MatchResponseDto;
import com.mundialscore.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
@RequiredArgsConstructor
public class MatchController {

    private final MatchService matchService;

    @GetMapping
    public List<MatchResponseDto> list() {
        return matchService.listMatches();
    }
}
