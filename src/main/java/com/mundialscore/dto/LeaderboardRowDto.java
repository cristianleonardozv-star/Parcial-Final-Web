package com.mundialscore.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeaderboardRowDto {
    private String username;
    private long totalPoints;
}
