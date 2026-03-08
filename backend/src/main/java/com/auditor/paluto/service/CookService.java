package com.auditor.paluto.service;

import com.auditor.paluto.dto.CookRegistrationDTO;
import com.auditor.paluto.entity.Cook;
import com.auditor.paluto.repository.CookRepository;
import com.auditor.paluto.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CookService {
    private final CookRepository cookRepository;
    private final PasswordEncoder passwordEncoder;

    public Cook registerCook(CookRegistrationDTO dto){
        Cook newCook = Cook.builder()
                //USER attr
                .firstname(dto.getFirstname())
                .lastname(dto.getLastname())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .address(dto.getAddress())
                .role("COOK")

                //COOK attr
                .hourly_rate(dto.getHourly_rate())
                .years_xp(dto.getYears_xp())
                .bio(dto.getBio())
                .build();

        return cookRepository.save(newCook);
    }
}
