package com.auditor.paluto.controller;

import com.auditor.paluto.dto.CookRegistrationDTO;
import com.auditor.paluto.entity.Cook;
import com.auditor.paluto.response.ApiResponse;
import com.auditor.paluto.service.CookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/cook")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class CookController {
    private final CookService cookService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<Cook>> registerCook(@RequestBody CookRegistrationDTO dto){
        Cook registeredCook = cookService.registerCook(dto);

        ApiResponse<Cook> response = ApiResponse.<Cook>builder()
                .success(true)
                .data(registeredCook)
                .error(null)
                .timestamp(LocalDateTime.now().toString())
                .build();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
