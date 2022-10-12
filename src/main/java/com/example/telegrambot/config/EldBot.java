package com.example.telegrambot.config;

import com.example.telegrambot.config.BotConfig;
import com.example.telegrambot.entity.Company;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.C;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@Slf4j
public class EldBot extends TelegramLongPollingBot {
     private final BotConfig config;

    public EldBot(BotConfig config) {
        this.config = config;
    }


    @Override
    public String getBotUsername() {
       return  config.getBotUsername();
    }

    @Override
    public String getBotToken() { return  config.getBotToken();}

    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
         if( message.equals("/start")){
          SendMessage sendMessage = new SendMessage();
            sendMessage.setText("Hi" + message.getChat().getFirstName());
            sendMessage.setChatId(message.getChatId());
             ///
         }



    }
    private void sendMessage(long chatId,String textToSend){
      SendMessage sendMessage = new SendMessage();
      Company company = new Company();
      textToSend = String.valueOf(company.getName());
         sendMessage.setChatId(chatId);
         sendMessage.setText(textToSend);

    }







}
