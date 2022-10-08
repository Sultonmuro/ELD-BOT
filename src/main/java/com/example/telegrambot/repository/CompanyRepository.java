package com.example.telegrambot.repository;

import com.example.telegrambot.entity.Company;
import com.example.telegrambot.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {

}
