package com.example.telegrambot.config;


import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;



@Configuration
@Data
public class BotConfig {
    @Value("${bot.name}")
      public String botUsername = "Eld123_bot";
    @Value("${bot.token}")
    public String botToken = "5658998856:AAESl5Zr11VDP0KDhC4z9Eos33oNosNU6io";

}



//
//    public sstatic SendMessage replyKeyboardMaker(long chatId,String textToSend){
//
//        SendMessage sendMessage = new SendMessage();
//        sendMessage.setChatId(String.valueOf(chatId));
//        sendMessage.setText(textToSend);
//        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
//
//        List<KeyboardRow> keyboardRowList = new ArrayList<>();
//        KeyboardRow row = new KeyboardRow();
//        row.add("Id list");
//
//        keyboardRowList.add(row);
//    replyKeyboardMarkup.setKeyboard(keyboardRowList);
//    sendMessage.setReplyMarkup(replyKeyboardMarkup);
//
//
//        return sendMessage;
//    }
//    }
//        if(update.hasMessage()){
//            if(update.getMessage().hasText()){
//                if(update.getMessage().getText().equals("Hello")){
//                    try {
//                        execute(sendInlineKeyBoardMessage(update.getMessage().getChatId()));
//                    } catch (TelegramApiException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }else if(update.hasCallbackQuery()){
//            try {
//                execute(new SendMessage().setText(
//                                update.getCallbackQuery().getData())
//                        .setChatId(update.getCallbackQuery().getMessage().getChatId()));
//            } catch (TelegramApiException e) {
//                e.printStackTrace();
//            }
//        }



//    public SendMessage sendInlineKeyboard(Long chatId) {
////        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
////        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
////        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
////        inlineKeyboardButton1.setText("Тык");
////        inlineKeyboardButton1.setCallbackData("Button \"Тык\" has been pressed");
////        inlineKeyboardButton2.setText("Тык2");
////        inlineKeyboardButton2.setCallbackData("Button \"Тык2\" has been pressed");
////        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
////        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
////        keyboardButtonsRow1.add(inlineKeyboardButton1);
////        keyboardButtonsRow1.add(new InlineKeyboardButton().setText("Fi4a").)
////        keyboardButtonsRow2.add(inlineKeyboardButton2);
////        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
////        rowList.add(keyboardButtonsRow1);
////        rowList.add(keyboardButtonsRow2);
////        inlineKeyboardMarkup.setKeyboard(rowList);
////        return new SendMessage()
////                .setChatId(chatId)
////                .setText("Пример")
////                .setReplyMarkup(inlineKeyboardMarkup);
////    }
//}
