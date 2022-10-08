package com.example.telegrambot.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DriverResDto {
    private Long id ;
    private String fullName;
    private String company_name;
    private LocalTime timeToDrive;
}
