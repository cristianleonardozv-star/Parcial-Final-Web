package com.mundialscore.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatchResponseDto {
    private Long id;
    private String homeTeam;
    private String awayTeam;
    private LocalDateTime matchDate;
    private boolean finished;
    private Integer realHomeGoals;
    private Integer realAwayGoals;
}
