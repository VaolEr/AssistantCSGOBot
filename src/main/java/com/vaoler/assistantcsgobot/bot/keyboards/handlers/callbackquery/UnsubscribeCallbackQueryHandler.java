package com.vaoler.assistantcsgobot.bot.keyboards.handlers.callbackquery;

import com.vaoler.assistantcsgobot.bot.keyboards.handlers.callbackquery.types.BotCallbackQueryType;
import com.vaoler.assistantcsgobot.bot.keyboards.handlers.callbackquery.types.CallbackQueryType;
import com.vaoler.assistantcsgobot.model.bot.Team;
import com.vaoler.assistantcsgobot.model.bot.User;
import com.vaoler.assistantcsgobot.service.LocaleMessageService;
import com.vaoler.assistantcsgobot.service.TeamsService;
import com.vaoler.assistantcsgobot.service.UsersService;
import com.vaoler.assistantcsgobot.service.UsersTeamsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class UnsubscribeCallbackQueryHandler implements CallbackQueryHandler {

    private final UsersService usersService;
    private final UsersTeamsService usersTeamsService;
    private final TeamsService teamsService;
    private final LocaleMessageService localeMessageService;

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

        log.info("Unsubscribe was requested from user {} for team {}", chatId, callbackTeamName);
        Optional<User> oCurrentUser = usersService.getUserByTelegramChatId(Long.parseLong(chatId));
        User currentUser;
        if (oCurrentUser.isPresent()) {
            currentUser = oCurrentUser.get();
            var userTeams = currentUser.getUserTeams();
            String finalCallbackTeamName = callbackTeamName;
            userTeams.removeIf(userTeam -> userTeam.getTeam().getName().contains(finalCallbackTeamName));
            currentUser.setUserTeams(userTeams);
            usersService.update(currentUser);
            Optional<Team> oTeam = teamsService.getTeamByName(callbackTeamName);
            if(oTeam.isPresent()) {
                Team currentTeam = oTeam.get();
                usersTeamsService.unsubscribeUserFromTeam(currentUser, currentTeam);
                return SendMessage.builder()
                        .chatId(chatId)
                        .text("You are successfully unsubscribed from " + callbackTeamName + " team!!!")
                        .build();
            } else{
                return SendMessage.builder()
                        .chatId(chatId)
                        .text(localeMessageService.getMessage("bot.message.callback.UNSUBSCRIBE.team_not_present"))
                        .build();
            }
        } else {
            return SendMessage.builder()
                    .chatId(chatId)
                    .text(localeMessageService.getMessage("bot.message.callback.UNSUBSCRIBE.user_not_present"))
                    .build();
        }
    }

    @Override
    public List<SendMessage> handleCallbackQueryMultiAnswer(CallbackQuery callbackQuery) {
        return null;
    }

    @Override
    public CallbackQueryType getHandlerQueryType() {
        return BotCallbackQueryType.UNSUBSCRIBE;
    }
}
