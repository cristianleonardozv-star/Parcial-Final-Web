package com.mundialscore.service;

import com.mundialscore.dto.UpdateMatchResultRequestDto;
import com.mundialscore.entity.Match;
import com.mundialscore.entity.Prediction;
import com.mundialscore.repository.MatchRepository;
import com.mundialscore.repository.PredictionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final MatchRepository matchRepository;
    private final PredictionRepository predictionRepository;
    private final MatchService matchService;
    private final ScoringService scoringService;

    @Transactional
    public void updateRealResultAndRecalculate(UpdateMatchResultRequestDto dto) {
        Match match = matchService.getMatchOrThrow(dto.getMatchId());

        match.setRealHomeGoals(dto.getRealHomeGoals());
        match.setRealAwayGoals(dto.getRealAwayGoals());
        match.setFinished(true);

        matchRepository.save(match);

        List<Prediction> predictions = predictionRepository.findByMatch_Id(match.getId());

        for (Prediction p : predictions) {
            int pts = scoringService.calculatePoints(
                    p.getPredictedHomeGoals(),
                    p.getPredictedAwayGoals(),
                    dto.getRealHomeGoals(),
                    dto.getRealAwayGoals()
            );
            p.setPoints(pts);
        }

        predictionRepository.saveAll(predictions);
    }
}
