package com.vaoler.assistantcsgobot.bot.keyboards.handlers.callbackquery;

import com.vaoler.assistantcsgobot.bot.keyboards.TeamsInlineKeyboard;
import com.vaoler.assistantcsgobot.bot.keyboards.handlers.callbackquery.types.BotCallbackQueryType;
import com.vaoler.assistantcsgobot.bot.keyboards.handlers.callbackquery.types.CallbackQueryType;
import com.vaoler.assistantcsgobot.service.LocaleMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import java.util.List;
@Slf4j
@Component
@RequiredArgsConstructor
public class TeamInfoCallbackQueryHandler implements CallbackQueryHandler {

    private final LocaleMessageService localeMessageService;
    private final TeamsInlineKeyboard teamsInlineKeyboard;

    @Override
    public SendMessage handleCallbackQuery(CallbackQuery callbackQuery) {

        String chatId = callbackQuery.getMessage().getChatId().toString();

        String callbackTeamName;
        try {
            callbackTeamName = callbackQuery.getData().split("_")[1];
        } catch (Exception e) {
            log.info(e.getMessage());
            callbackTeamName = "";
        }

        log.info("Team info was requested from user {} for team {}", chatId, callbackTeamName);
        return teamsInlineKeyboard.teamInfoInlineKeyboardMessage(callbackTeamName, chatId);
    }

    @Override
    public List<SendMessage> handleCallbackQueryMultiAnswer(CallbackQuery callbackQuery) {
        return null;
    }

    @Override
    public CallbackQueryType getHandlerQueryType() {
        return BotCallbackQueryType.TEAMINFO;
    }
}
