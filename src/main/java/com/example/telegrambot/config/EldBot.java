package com.example.telegrambot.config;

import com.example.telegrambot.config.BotConfig;
import com.example.telegrambot.entity.Company;
import jdk.dynalink.linker.LinkerServices;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.C;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class EldBot extends TelegramLongPollingBot {

    private final BotConfig config;

    public EldBot(BotConfig config) {
        this.config = config;
    }


    @Override
    public String getBotUsername() {
        return config.getBotUsername();
    }

    @Override
    public String getBotToken() {
        return config.getBotToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.getMessage().hasText()) {
            if (update.getMessage().equals("/start")) {
                Message message = update.getMessage();
                String str = new String("Welcome to ELD BOT" + message.getChat().getFirstName());
                sendMessage(message.getChatId(), str);
                getSettingsKeyboard();
            } else if (!update.getMessage().equals("/start")) {
                Message message = update.getMessage();
                String messageToSend = "Type /help to check the commandList!";
                sendMessage(message.getChatId(), messageToSend);
            }
        }
    }
    private void sendMessage(long chatId, String textToSend) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(textToSend);
    }
    private static ReplyKeyboardMarkup getSettingsKeyboard() {
ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
replyKeyboardMarkup.setOneTimeKeyboard(true);
replyKeyboardMarkup.setResizeKeyboard(true);
replyKeyboardMarkup.setSelective(true);
        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add("Fix");
        keyboardRowList.add(row);
        KeyboardRow row1 = new KeyboardRow();
        row1.add("Check");
        keyboardRowList.add(row1);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
        return replyKeyboardMarkup;
    }
    private void commandList(){
        List<String > commandList = new ArrayList<>();
        commandList.add("/fix" +
                "/check - >  " +
                "/idList - > List with workers id  " );

    }
}
