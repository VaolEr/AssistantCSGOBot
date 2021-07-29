package com.vaoler.assistantcsgobot.bot.keyboards.handlers.inputmessage;

import com.vaoler.assistantcsgobot.bot.keyboards.handlers.callbackquery.types.BotCallbackQueryType;
import com.vaoler.assistantcsgobot.bot.keyboards.handlers.inputmessage.commands.AssistantCSGOBotCommand;
import com.vaoler.assistantcsgobot.bot.keyboards.handlers.inputmessage.commands.TelegramBotCommand;
import com.vaoler.assistantcsgobot.service.ReplyMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.List;
import java.util.Optional;

/**
 * Parse the input message as command
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class InputMessageCommandParser {
    private final ReplyMessageService messagesService;
    private final List<InputMessageHandler> inputMessageHandlers;

    public SendMessage processInputMessageCommand(Message inputMessage){

        String inputCommand = inputMessage.getText().split("_")[0];

        TelegramBotCommand inputBotCommand;
        try{
            inputBotCommand = AssistantCSGOBotCommand.findByTelegramBotCommand(inputCommand);
        } catch (IllegalArgumentException e){
            log.info(e.getMessage());
            inputBotCommand = AssistantCSGOBotCommand.NOT$IMPLEMENTED$;
        }

        TelegramBotCommand finalTelegramBotCommand = inputBotCommand;

        Optional<InputMessageHandler> messageHandler = inputMessageHandlers.stream().
                filter(telegramBotCommand -> telegramBotCommand.getBotCommand().equals(finalTelegramBotCommand)).findFirst();

        return messageHandler.map(handler -> handler.handleInputMessage(inputMessage)).orElse(messagesService.getWarningReplyMessage(inputMessage.getChatId().toString(), "bot.commands.unknown_command"));
    }
}
