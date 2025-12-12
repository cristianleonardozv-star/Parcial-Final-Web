package com.mundialscore.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateMatchResultRequestDto {

    @NotNull
    private Long matchId;

    @Min(0)
    private int realHomeGoals;

    @Min(0)
    private int realAwayGoals;
}
