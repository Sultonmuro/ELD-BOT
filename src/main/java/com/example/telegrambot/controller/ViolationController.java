package com.example.telegrambot.controller;

import com.example.telegrambot.dto.ApiResponse;
import com.example.telegrambot.entity.Violation;
import com.example.telegrambot.repository.ViolationRepository;
import com.example.telegrambot.service.ViolationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/violation")
@RestController
@RequiredArgsConstructor
public class ViolationController {
    private final ViolationRepository violationRepository;
    private final ViolationService violationService;

    @GetMapping("/getAll")
    public ResponseEntity<?> read(){
        List<Violation> all = violationRepository.findAll();
        return ResponseEntity.ok(all);
    }
    @GetMapping("/getOne")
    public ResponseEntity<?> getOne(@PathVariable Long id ){
        ApiResponse<?> one = violationService.getOne(id);
        return ResponseEntity.status(one.isSuccess() ? 200 : 404).body(one);
    }
    @PutMapping("/fix")
    public ResponseEntity<?> fixViolation(@RequestBody Violation violation,@PathVariable Long id ){
        ApiResponse<?> fix = violationService.fix(violation, id);
        return ResponseEntity.status(fix.isSuccess() ? 202 : 404).body(fix);

    }

}
