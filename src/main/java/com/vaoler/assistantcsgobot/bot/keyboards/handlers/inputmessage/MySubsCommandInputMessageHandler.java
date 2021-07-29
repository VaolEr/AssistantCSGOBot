package com.vaoler.assistantcsgobot.bot.keyboards.handlers.inputmessage;

import com.vaoler.assistantcsgobot.bot.keyboards.TeamsInlineKeyboard;
import com.vaoler.assistantcsgobot.bot.keyboards.handlers.inputmessage.commands.AssistantCSGOBotCommand;
import com.vaoler.assistantcsgobot.bot.keyboards.handlers.inputmessage.commands.TelegramBotCommand;
import com.vaoler.assistantcsgobot.model.bot.Team;
import com.vaoler.assistantcsgobot.model.bot.User;
import com.vaoler.assistantcsgobot.model.bot.UserTeam;
import com.vaoler.assistantcsgobot.service.LocaleMessageService;
import com.vaoler.assistantcsgobot.service.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class MySubsCommandInputMessageHandler implements InputMessageHandler{

    private final UsersService usersService;
    private final LocaleMessageService localeMessageService;
    private final TeamsInlineKeyboard teamsInlineKeyboard;

    @Override
    public SendMessage handleInputMessage(Message message) {
        log.debug("My subscriptions was asked");
        Optional<User> oUser = usersService.getUserByTelegramChatId(message.getChatId());
        User user;
        List<UserTeam> userTeams;
        List<Team> teams;
        if (oUser.isPresent()) {
            user = oUser.get();
            userTeams = user.getUserTeams();
            if (userTeams.isEmpty()) {
                return SendMessage.builder()
                        .chatId(message.getChatId().toString())
                        .text(localeMessageService.getMessage("bot.messages.mySubs_emptySubsListMessage"))
                        .build();
            }
            teams = userTeams.stream().map(UserTeam::getTeam).collect(Collectors.toList());
            return teamsInlineKeyboard.subscribedTeamsInlineKeyBoardMessage(message.getChatId().toString(), teams);
        }
        return SendMessage.builder()
                .chatId(message.getChatId().toString())
                .text(localeMessageService.getMessage("There will be teams on which you are subscribed"))
                .build();
    }

    @Override
    public TelegramBotCommand getBotCommand() {
        return AssistantCSGOBotCommand.MYSUBS;
    }
}
