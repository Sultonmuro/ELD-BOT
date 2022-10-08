package com.example.telegrambot.service;

import com.example.telegrambot.dto.ApiResponse;
import com.example.telegrambot.entity.Company;
import com.example.telegrambot.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    public ApiResponse createCompany(Company company) {
        Company save = companyRepository.save(company);
        return com.example.telegrambot.dto.ApiResponse.builder().message("Created").data(save).success(true).build();
    }

    public ApiResponse<?> deleteCompany(Long id) {
        Company company = companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company with this id not found "));
        companyRepository.delete(company);
        return ApiResponse.builder().message("DELETED").success(true).build();

    }

    public ApiResponse<?> editCompany(Company company, Long id) {
        Company company11 = companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company with this id not found"));
        company11.setId(company11.getId());
        company11.setName(company11.getName());
        company11.setActual(company11.isActual());
        Company save = companyRepository.save(company11);
        return ApiResponse.builder()
                .message("Edited")
                .success(true)
                .data(save)
                .build();
    }

    public ApiResponse<?> getOne(Long id) {
        Optional<Company> byId = companyRepository.findById(id);
        return ApiResponse.builder().data(byId).success(true).message("Got one ! ").build();
    }
}
