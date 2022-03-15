package com.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Bot extends TelegramLongPollingBot {
    SendMessage sendMessage = new SendMessage();
    Bot bot;
    @Override
    public String getBotUsername() {
        return "@letsnewbot_bot";
    }

    @Override
    public String getBotToken() {
        return "5076632172:AAEsozThZiwZKSspYPtky6JX1r3qCdgEadQ";
    }

    @Override
    public void onUpdateReceived(Update update) {
        sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
        sendMessage.setText("hi");
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public static class Main {

        public static void main(String[] args) {
            try{
                TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
                telegramBotsApi.registerBot(new Bot());
            }catch (TelegramApiException e){
                e.printStackTrace();
            }

        }

    }


}
