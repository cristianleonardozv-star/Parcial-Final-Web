package com.mundialscore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMatchRequestDto {
    private String homeTeam;
    private String awayTeam;
    private LocalDateTime matchDate;
}
