package com.mundialscore.controller;

import com.mundialscore.dto.CreatePredictionRequestDto;
import com.mundialscore.dto.PredictionResultDto;
import com.mundialscore.service.PredictionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/predictions")
@RequiredArgsConstructor
public class PredictionController {

    private final PredictionService predictionService;

    @PostMapping
    public ResponseEntity<?> createOrUpdate(Authentication auth,
                                           @Valid @RequestBody CreatePredictionRequestDto dto) {
        predictionService.createOrUpdatePrediction(auth.getName(), dto);
        return ResponseEntity.ok(Map.of("message", "Pronóstico guardado."));
    }

    @GetMapping("/me")
    public List<PredictionResultDto> myResults(Authentication auth) {
        return predictionService.myResults(auth.getName());
    }
}
