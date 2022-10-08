package com.example.telegrambot.controller;

import com.example.telegrambot.dto.ApiResponse;
import com.example.telegrambot.entity.Company;
import com.example.telegrambot.repository.CompanyRepository;
import com.example.telegrambot.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.glassfish.jersey.server.monitoring.ApplicationInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyRepository companyRepository;

    private  final CompanyService companyService;


    @GetMapping("/getAll")
    public ResponseEntity<?> read(){
        List<Company> all = companyRepository.findAll();
        ResponseEntity<?> ok = ResponseEntity.ok(all);
        return ok;
    }
    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id ){
        ApiResponse<?> one = companyService.getOne(id);
        return ResponseEntity.ok(one);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> edit(@RequestBody Company company,@PathVariable Long id ){
        ApiResponse<?> apiResponse = companyService.editCompany(company, id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 :  404).body(apiResponse);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Company company){
        ApiResponse company1 = companyService.createCompany(company);
        return ResponseEntity.status(company1.isSuccess()  ? 201 : 404 ).body(company1);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id ){
        ApiResponse<?> apiResponse = companyService.deleteCompany(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 202 : 404).body(apiResponse);
    }






}
