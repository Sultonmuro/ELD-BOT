package com.example.telegrambot.service;

import com.example.telegrambot.dto.ApiResponse;
import com.example.telegrambot.entity.Dispatch;
import com.example.telegrambot.entity.Violation;
import com.example.telegrambot.repository.ViolationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ViolationService {
    private final ViolationRepository violationRepository;

    public ApiResponse<?> getOne(Long id) {
        Violation violation = violationRepository.findById(id).orElseThrow(() -> new RuntimeException("VIOLATION WITH THIS ID DOESN'T EXIST!"));
        return ApiResponse.builder()
                .data(violation)
                .message("Got")
                .success(true)
                .build();

    }

    public ApiResponse<?> fix(Violation violation, Long id) {
        Dispatch dispatch = new Dispatch();
        Violation violation1 = violationRepository.findById(id).orElseThrow(() -> new RuntimeException("VIOLATION WITH THIS ID DOESN'T EXIST!"));
        if(!violation1.isIsFixed()){
            return ApiResponse.builder()
                    .success(false)
                    .data(id)
                    .message(" NOT FIXED" + violation.getType())
                    .build();
        }else
            return ApiResponse.builder()
                    .success(true)
                    .data(id)
                    .message("FIXED" + violation.getType() + dispatch.getId() )
                    .build();

    }

    public ApiResponse<?> delete(Long id) {
        Violation violation = violationRepository.findById(id).orElseThrow(() -> new RuntimeException("Violation doesn't exist"));
        violationRepository.delete(violation);
        return ApiResponse.builder().success(true).message("DELETED").build();
    }
}
