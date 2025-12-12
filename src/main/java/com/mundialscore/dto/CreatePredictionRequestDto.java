package com.mundialscore.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePredictionRequestDto {

    @NotNull
    private Long matchId;

    @Min(0)
    private int predictedHomeGoals;

    @Min(0)
    private int predictedAwayGoals;
}
