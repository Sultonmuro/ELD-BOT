package com.example.telegrambot.dto;


import lombok.*;

import java.sql.Timestamp;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DriverDto {
    private Long id ;
    private Long company_id;
    private LocalTime timeToDrive;

}
