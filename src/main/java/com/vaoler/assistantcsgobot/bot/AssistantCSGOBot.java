package com.vaoler.assistantcsgobot.bot;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Slf4j
@Component
@RequiredArgsConstructor
public class AssistantCSGOBot extends TelegramWebhookBot {

    //private final AbiosAuthenticationService abiosAuthenticationService;

    // This is telegram bot Username
    @Value("${app.bots.usernames.assistant-csgo-telegram-bot-Username}")
    private String botUsername;

    // This is telegram bot token
    @Value("${app.bots.tokens.assistant-csgo-telegram-bot-Token}")
    private String botToken;

    @Value("${api.bots.webhookPaths.assistant-csgo-telegram-bot-Path}")
    private String botPath;

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MMMM-d HH:mm:ss", Locale.ENGLISH);

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {

        CallbackQuery callbackQuery;
        Message message;
        String chatId;

        if (update.hasCallbackQuery() && !update.hasMessage()) {
            callbackQuery = update.getCallbackQuery();
            chatId = callbackQuery.getMessage().getChatId().toString();
            message = update.getMessage();
        } else {
            message = update.getMessage();
            chatId = message.getChatId().toString();
            callbackQuery = update.getCallbackQuery();
        }

        SendMessage sendMessage = new SendMessage();

        String userName;
        boolean isBot;
        String messageDateTime;
        String messageText;

        userName = message.getFrom().getUserName();
        isBot = message.getFrom().getIsBot();
        messageDateTime = LocalDateTime.ofEpochSecond(message.getDate(), 0, ZoneOffset.ofHours(3)).format(dateTimeFormatter);
        messageText = message.getText();

        log.info("New message from User: {}, isBot: {}, chatId: {}, date: {}, with text: {}",
                userName,
                isBot,
                chatId,
                messageDateTime,
                messageText);

        sendMessage.setChatId(chatId);
        sendMessage.setText("Bot is still like a 4 years ol child. Be passions, please.");
        return sendMessage;
    }

    @Override
    public String getBotPath() {
        return botPath;
    }
}
