package com.vaoler.assistantcsgobot.bot;

import com.vaoler.assistantcsgobot.bot.keyboards.TeamsInlineKeyboard;
import com.vaoler.assistantcsgobot.bot.keyboards.handlers.callbackquery.CallbackQueryParser;
import com.vaoler.assistantcsgobot.model.bot.Team;
import com.vaoler.assistantcsgobot.model.bot.User;
import com.vaoler.assistantcsgobot.model.bot.UserTeam;
import com.vaoler.assistantcsgobot.service.*;
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
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class AssistantCSGOBot extends TelegramWebhookBot {

    private final LocaleMessageService localeMessageService;
    private final UsersService usersService;
    private final CallbackQueryParser callbackQueryParser;
    private final TeamsInlineKeyboard teamsInlineKeyboard;


    // This is telegram bot Username
    @Value("${app.bots.usernames.assistant-csgo-telegram-bot-Username}")
    private String botUsername;

    // This is telegram bot token
    @Value("${app.bots.tokens.assistant-csgo-telegram-bot-Token}")
    private String botToken;

    @Value("${api.bots.webhookPaths.assistant-csgo-telegram-bot-Path}")
    private String botPath;

    @Value("${app.sendMessage.empty}")
    private String emptySendMessageText;

    @Value("${app.sendMessage.NoResultsForTeam}")
    private String noResultsForTeamSendMessageText;

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

        if (callbackQuery != null && message == null) {
            log.info("New callbackQuery from User: {} with data: {}", update.getCallbackQuery().getFrom().getUserName(),
                    update.getCallbackQuery().getData());

            return callbackQueryParser.processCallbackQuery(update.getCallbackQuery());

        } else {

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

            return prepareSendMessageAnswerBasedOnInputMessageText(messageText, chatId);
        }
    }

    private SendMessage prepareSendMessageAnswerBasedOnInputMessageText(String messageText, String chatId) {

        SendMessage sendMessage = new SendMessage();
        Objects.requireNonNull(messageText);

        String botCommand = messageText.split("_")[0];

        switch (botCommand) {

            case ("/start"):
                //TODO create new method name!
                return getSendMessageAfterUserValidation(chatId);

            case ("/help"):
            case ("help"):
                log.debug("Help was asked");
                return SendMessage.builder()
                        .chatId(chatId)
                        .text(localeMessageService.getMessage("bot.messages.help_message"))
                        .build();

            case ("/teams"):
            case ("teams"):
                log.debug("Inline teams keyboard was asked.");
                return teamsInlineKeyboard.sendInlineKeyBoardMessage(chatId);

            case ("/findTeam"):
                log.debug("Find team was called");
                String teamName = messageText.split("_")[1];
                return teamsInlineKeyboard.teamSubscribeInlineKeyboardOrNotFoundMessage(teamName, chatId);

            case ("/mySubs"):
                log.debug("My subscriptions was asked");
                Optional<User> oUser = usersService.getUserByTelegramChatId(Long.parseLong(chatId));
                User user;
                List<UserTeam> userTeams;
                List<Team> teams;
                if (oUser.isPresent()) {
                    user = oUser.get();
                    userTeams = user.getUserTeams();
                    if (userTeams.isEmpty()) {
                        return SendMessage.builder()
                                .chatId(chatId)
                                .text(localeMessageService.getMessage("bot.messages.mySubs_emptySubsListMessage"))
                                .build();
                    }
                    teams = userTeams.stream().map(UserTeam::getTeam).collect(Collectors.toList());
                    return teamsInlineKeyboard.subscribedTeamsInlineKeyBoardMessage(chatId, teams);
                }
                return SendMessage.builder()
                        .chatId(chatId)
                        .text(localeMessageService.getMessage("There will be teams on which you are subscribed"))
                        .build();

            default:
                sendMessage.setChatId(chatId);
                sendMessage.setText(localeMessageService.getMessage("bot.commands.unknown_command"));
                return sendMessage;
        }
    }

    private SendMessage getSendMessageAfterUserValidation(String chatId) {
        Optional<User> botUser = usersService.getUserByTelegramChatId(Long.parseLong(chatId));
        if (botUser.isEmpty()) {
            User newUser = new User();
            newUser.setTelegramChatId(Long.parseLong(chatId));
            usersService.create(newUser);
            log.info("New bot user was created!");
            return SendMessage.builder()
                    .chatId(chatId)
                    .text(localeMessageService.getMessage("bot.messages.start_command_message_new_user"))
                    .build();
        }
        return SendMessage.builder()
                .chatId(chatId)
                .text(localeMessageService.getMessage("bot.messages.start_command_message_old_user"))
                .build();
    }


    @Override
    public String getBotPath() {
        return botPath;
    }
}
