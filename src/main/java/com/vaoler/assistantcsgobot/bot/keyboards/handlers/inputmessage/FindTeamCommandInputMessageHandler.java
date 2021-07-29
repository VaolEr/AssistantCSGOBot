package com.vaoler.assistantcsgobot.bot.keyboards.handlers.inputmessage;

import com.vaoler.assistantcsgobot.bot.keyboards.TeamsInlineKeyboard;
import com.vaoler.assistantcsgobot.bot.keyboards.handlers.inputmessage.commands.AssistantCSGOBotCommand;
import com.vaoler.assistantcsgobot.bot.keyboards.handlers.inputmessage.commands.TelegramBotCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

/**
 * This handler describes the behavior of the bot when executing the "/findteam_Team Name" command.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class FindTeamCommandInputMessageHandler implements InputMessageHandler{

    private final TeamsInlineKeyboard teamsInlineKeyboard;

    @Override
    public SendMessage handleInputMessage(Message message) {
        log.debug("Find team was called");
        String teamName = message.getText().split("_")[1];
        return teamsInlineKeyboard.teamSubscribeInlineKeyboardOrNotFoundMessage(teamName, message.getChatId().toString());
    }

    @Override
    public TelegramBotCommand getBotCommand() {
        return AssistantCSGOBotCommand.FINDTEAM;
    }
}
