package com.example.telegrambot.config;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.jsse.JSSEUtil;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
@RequiredArgsConstructor
public class BotInit {
  private final EldBot eldBot;

  @EventListener({ContextRefreshedEvent.class})
    public void init() throws TelegramApiException{
      TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
    try{
        telegramBotsApi.registerBot(eldBot);
    }catch (TelegramApiException e){
        System.out.println(e);

    }
  }
}
