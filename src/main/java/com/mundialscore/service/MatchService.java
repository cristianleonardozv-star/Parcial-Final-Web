package com.mundialscore.service;

import com.mundialscore.dto.MatchResponseDto;
import com.mundialscore.entity.Match;
import com.mundialscore.exception.NotFoundException;
import com.mundialscore.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchService {

    private final MatchRepository matchRepository;

    public List<MatchResponseDto> listMatches() {
        return matchRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    public MatchResponseDto createMatch(com.mundialscore.dto.CreateMatchRequestDto dto) {
        Match match = Match.builder()
                .homeTeam(dto.getHomeTeam())
                .awayTeam(dto.getAwayTeam())
                .matchDate(dto.getMatchDate())
                .finished(false)
                .build();
        Match saved = matchRepository.save(match);
        return toDto(saved);
    }

    public Match getMatchOrThrow(Long id) {
        return matchRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Partido no encontrado: " + id));
    }

    public MatchResponseDto toDto(Match m) {
        return MatchResponseDto.builder()
                .id(m.getId())
                .homeTeam(m.getHomeTeam())
                .awayTeam(m.getAwayTeam())
                .matchDate(m.getMatchDate())
                .finished(m.isFinished())
                .realHomeGoals(m.getRealHomeGoals())
                .realAwayGoals(m.getRealAwayGoals())
                .build();
    }

    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }
}
