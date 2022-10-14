package com.example.telegrambot;

import com.example.telegrambot.config.EldBot;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.BotSession;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
@Slf4j

public class TelegrambotApplication {





    public static void main(String[] args) throws TelegramApiException {
SpringApplication.run(TelegrambotApplication.class,args);
    }
}
