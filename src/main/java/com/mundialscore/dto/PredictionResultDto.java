package com.mundialscore.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PredictionResultDto {
    private Long matchId;
    private String homeTeam;
    private String awayTeam;

    private int predictedHomeGoals;
    private int predictedAwayGoals;

    private Integer realHomeGoals;
    private Integer realAwayGoals;

    private boolean finished;
    private int points;
}
