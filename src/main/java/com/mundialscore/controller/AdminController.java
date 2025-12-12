package com.mundialscore.controller;

import com.mundialscore.dto.UpdateMatchResultRequestDto;
import com.mundialscore.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/matches/result")
    public ResponseEntity<?> updateResult(@Valid @RequestBody UpdateMatchResultRequestDto dto) {
        adminService.updateRealResultAndRecalculate(dto);
        return ResponseEntity.ok(Map.of("message", "Resultado actualizado y puntos recalculados."));
    }
}
