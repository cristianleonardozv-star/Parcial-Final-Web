package com.mundialscore.service;

import com.mundialscore.dto.CreatePredictionRequestDto;
import com.mundialscore.dto.PredictionResultDto;
import com.mundialscore.entity.Match;
import com.mundialscore.entity.Prediction;
import com.mundialscore.entity.User;
import com.mundialscore.exception.BadRequestException;
import com.mundialscore.exception.NotFoundException;
import com.mundialscore.repository.PredictionRepository;
import com.mundialscore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PredictionService {

    private final PredictionRepository predictionRepository;
    private final UserRepository userRepository;
    private final MatchService matchService;

    public void createOrUpdatePrediction(String username, CreatePredictionRequestDto dto) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("Usuario no encontrado: " + username));

        Match match = matchService.getMatchOrThrow(dto.getMatchId());

        if (match.isFinished()) {
            throw new BadRequestException("No puedes apostar. El partido ya finalizó.");
        }

        Prediction prediction = predictionRepository.findByUser_IdAndMatch_Id(user.getId(), match.getId())
                .orElse(Prediction.builder().user(user).match(match).build());

        prediction.setPredictedHomeGoals(dto.getPredictedHomeGoals());
        prediction.setPredictedAwayGoals(dto.getPredictedAwayGoals());

        // Si aún no está finalizado, puntos se quedan en 0 (se recalcula al finalizar)
        prediction.setPoints(0);

        predictionRepository.save(prediction);
    }

    public List<PredictionResultDto> myResults(String username) {
        return predictionRepository.findByUser_UsernameOrderByIdDesc(username)
                .stream()
                .map(p -> PredictionResultDto.builder()
                        .matchId(p.getMatch().getId())
                        .homeTeam(p.getMatch().getHomeTeam())
                        .awayTeam(p.getMatch().getAwayTeam())
                        .predictedHomeGoals(p.getPredictedHomeGoals())
                        .predictedAwayGoals(p.getPredictedAwayGoals())
                        .realHomeGoals(p.getMatch().getRealHomeGoals())
                        .realAwayGoals(p.getMatch().getRealAwayGoals())
                        .finished(p.getMatch().isFinished())
                        .points(p.getPoints())
                        .build())
                .toList();
    }
}
