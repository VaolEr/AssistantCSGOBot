package com.vaoler.assistantcsgobot.bot.keyboards.handlers.callbackquery;

import com.vaoler.assistantcsgobot.bot.keyboards.handlers.callbackquery.types.BotCallbackQueryType;
import com.vaoler.assistantcsgobot.bot.keyboards.handlers.callbackquery.types.CallbackQueryType;
import com.vaoler.assistantcsgobot.model.bot.Team;
import com.vaoler.assistantcsgobot.model.bot.User;
import com.vaoler.assistantcsgobot.model.bot.UserTeam;
import com.vaoler.assistantcsgobot.service.LocaleMessageService;
import com.vaoler.assistantcsgobot.service.TeamsService;
import com.vaoler.assistantcsgobot.service.UsersService;
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
public class SubscribeCallbackQueryHandler implements CallbackQueryHandler {

    private final UsersService usersService;
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

        log.info("Subscribe was requested from user {} for team {}", chatId, callbackTeamName);
        Optional<User> oUser = usersService.getUserByTelegramChatId(Long.parseLong(chatId));
        User user;
        Team team;
        if (oUser.isPresent()) {
            user = oUser.get();
            Optional<Team> oTeam = teamsService.getTeamByName(callbackTeamName);

            if (oTeam.isPresent()) {
                team = oTeam.get();
                var userTeams = user.getUserTeams();
                for (UserTeam userTeam : userTeams) {
                    // Check for existing subscription to team
                    if (userTeam.getTeam().getName().contains(callbackTeamName)) {
                        return SendMessage.builder()
                                .chatId(chatId)
                                .text("You are already subscribed to " + callbackTeamName + " team!!!")
                                .build();
                    }
                }

                UserTeam userTeam = new UserTeam();
                userTeam.setTeam(team);
                userTeam.setUser(user);
                userTeams.add(userTeam);
                user.setUserTeams(userTeams);
                usersService.update(user);

            } else {
                //TODO change messages to lacaled messages
                log.info("Team " + callbackTeamName + " is not present!");
                return SendMessage.builder()
                        .chatId(chatId)
                        .text("Something goes wrong! Connect to admin and describe problem!")
                        .build();
            }

        } else {
            log.info("User " + chatId + " is not present!");
            return SendMessage.builder()
                    .chatId(chatId)
                    .text("Something goes wrong! Connect to admin and describe problem!")
                    .build();
        }
        return SendMessage.builder()
                .chatId(chatId)
                .text("You are successfully subscribed to " + callbackTeamName + " !")
                .build();
    }

    @Override
    public List<SendMessage> handleCallbackQueryMultiAnswer(CallbackQuery callbackQuery) {
        return null;
    }

    @Override
    public CallbackQueryType getHandlerQueryType() {
        return BotCallbackQueryType.SUBSCRIBE;
    }
}
