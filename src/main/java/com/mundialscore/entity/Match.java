package com.mundialscore.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String homeTeam;

    @Column(nullable = false)
    private String awayTeam;

    @Column(nullable = false)
    private LocalDateTime matchDate;

    // Resultado real (admin)
    private Integer realHomeGoals;
    private Integer realAwayGoals;

    @Column(nullable = false)
    @Builder.Default
    private boolean finished = false;
}
