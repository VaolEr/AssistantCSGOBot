package com.vaoler.assistantcsgobot.bot.keyboards.handlers.callbackquery;

import com.vaoler.assistantcsgobot.bot.keyboards.handlers.callbackquery.types.CallbackQueryType;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import java.util.List;

public interface CallbackQueryHandler {
    SendMessage handleCallbackQuery(CallbackQuery callbackQuery);

    List<SendMessage> handleCallbackQueryMultiAnswer(CallbackQuery callbackQuery);

    CallbackQueryType getHandlerQueryType();
}
