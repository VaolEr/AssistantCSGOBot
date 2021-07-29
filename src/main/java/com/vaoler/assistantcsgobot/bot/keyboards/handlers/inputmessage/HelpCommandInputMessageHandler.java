package com.vaoler.assistantcsgobot.bot.keyboards.handlers.inputmessage;

import com.vaoler.assistantcsgobot.bot.keyboards.handlers.inputmessage.commands.AssistantCSGOBotCommand;
import com.vaoler.assistantcsgobot.bot.keyboards.handlers.inputmessage.commands.TelegramBotCommand;
import com.vaoler.assistantcsgobot.service.LocaleMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

/**
 * This handler describes the behavior of the bot when executing the "/help" command.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class HelpCommandInputMessageHandler  implements InputMessageHandler{

    private final LocaleMessageService localeMessageService;

    @Override
    public SendMessage handleInputMessage(Message message) {
        log.debug("Help was asked");
        return SendMessage.builder()
                .chatId(message.getChatId().toString())
                .text(localeMessageService.getMessage("bot.messages.help_message"))
                .build();
    }

    @Override
    public TelegramBotCommand getBotCommand() {
        return AssistantCSGOBotCommand.HELP;
    }
}
