package com.example.telegrambot.repository;

import com.example.telegrambot.entity.Violation;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViolationRepository extends JpaRepository<Violation,Long> {

}
