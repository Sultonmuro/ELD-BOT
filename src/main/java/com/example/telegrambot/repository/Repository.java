package com.example.telegrambot.repository;

import org.hibernate.sql.Update;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface Repository {


      SendMessage shareContact ( Update update);




}
