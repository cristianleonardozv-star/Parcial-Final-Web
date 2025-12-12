package com.mundialscore.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "predictions",
       uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "match_id"}))
public class Prediction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "match_id")
    private Match match;

    @Column(nullable = false)
    private int predictedHomeGoals;

    @Column(nullable = false)
    private int predictedAwayGoals;

    // puntos calculados cuando el partido finaliza / admin registra resultado
    @Column(nullable = false)
    @Builder.Default
    private int points = 0;
}
