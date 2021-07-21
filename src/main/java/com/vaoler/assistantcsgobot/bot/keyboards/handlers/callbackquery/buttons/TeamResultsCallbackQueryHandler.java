package com.vaoler.assistantcsgobot.bot.keyboards.handlers.callbackquery.buttons;

import com.vaoler.assistantcsgobot.bot.keyboards.handlers.callbackquery.BotCallbackQueryType;
import com.vaoler.assistantcsgobot.bot.keyboards.handlers.callbackquery.CallbackQueryHandler;
import com.vaoler.assistantcsgobot.bot.keyboards.handlers.callbackquery.CallbackQueryType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.maven.surefire.shared.lang3.NotImplementedException;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class TeamResultsCallbackQueryHandler implements CallbackQueryHandler {

    private static final CallbackQueryType HANDLER_QUERY_TYPE = BotCallbackQueryType.TEAMRESULTS;

    @Override
    public SendMessage handleCallbackQuery(CallbackQuery callbackQuery) {

        throw new NotImplementedException("handleCallbackQuery not implemented in " + TeamResultsCallbackQueryHandler.class);

    }

    @Override
    public List<SendMessage> handleCallbackQueryMultiAnswer(CallbackQuery callbackQuery){

        String callbackTeamName = callbackQuery.getData().split("_")[1];

        List<SendMessage> sendMessages = new ArrayList<>();

        Message message = callbackQuery.getMessage();

        return sendMessages;
    }


    @Override
    public CallbackQueryType getHandlerQueryType() {
        return HANDLER_QUERY_TYPE;
    }
}
