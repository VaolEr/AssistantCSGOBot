package com.vaoler.assistantcsgobot.bot.keyboards.handlers.inputmessage;

import com.vaoler.assistantcsgobot.bot.keyboards.handlers.inputmessage.commands.TelegramBotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface InputMessageHandler {
    SendMessage handleInputMessage(Message message);
    TelegramBotCommand getBotCommand();
}
