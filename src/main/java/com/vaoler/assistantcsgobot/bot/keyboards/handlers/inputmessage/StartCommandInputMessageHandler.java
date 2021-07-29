package com.vaoler.assistantcsgobot.bot.keyboards.handlers.inputmessage;

import com.vaoler.assistantcsgobot.bot.keyboards.handlers.inputmessage.commands.AssistantCSGOBotCommand;
import com.vaoler.assistantcsgobot.bot.keyboards.handlers.inputmessage.commands.TelegramBotCommand;
import com.vaoler.assistantcsgobot.model.bot.User;
import com.vaoler.assistantcsgobot.service.LocaleMessageService;
import com.vaoler.assistantcsgobot.service.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Optional;

/**
 * This handler describes the behavior of the bot when executing the "/start" command.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class StartCommandInputMessageHandler implements InputMessageHandler{

    private final UsersService usersService;
    private final LocaleMessageService localeMessageService;

    @Override
    public SendMessage handleInputMessage(Message message) {
        Optional<User> botUser = usersService.getUserByTelegramChatId(message.getChatId());
        String chatId = message.getChatId().toString();
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
    public TelegramBotCommand getBotCommand() {
        return AssistantCSGOBotCommand.START;
    }
}
