package com.mundialscore.service;

import org.springframework.stereotype.Service;

@Service
public class ScoringService {

    public int calculatePoints(int predHome, int predAway, int realHome, int realAway) {

        // 5 puntos: marcador exacto
        if (predHome == realHome && predAway == realAway) {
            return 5;
        }

        int predOutcome = outcome(predHome, predAway);
        int realOutcome = outcome(realHome, realAway);

        // 3 puntos: acierta ganador o empate
        if (predOutcome == realOutcome) {
            return 3;
        }

        // 1 punto: no acierta el ganador, pero acierta goles de algún equipo
        if (predHome == realHome || predAway == realAway) {
            return 1;
        }

        return 0;
    }

    // 1 = gana local, 0 = empate, -1 = gana visitante
    private int outcome(int home, int away) {
        if (home > away) return 1;
        if (home < away) return -1;
        return 0;
    }
}
