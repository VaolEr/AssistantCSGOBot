package com.vaoler.assistantcsgobot.bot.keyboards;

import com.vaoler.assistantcsgobot.bot.keyboards.abstractkeyboards.AbstractInlineKeyboard;
import com.vaoler.assistantcsgobot.model.bot.Team;
import com.vaoler.assistantcsgobot.service.LocaleMessageService;
import com.vaoler.assistantcsgobot.service.TeamsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TeamsInlineKeyboard extends AbstractInlineKeyboard {

    private final LocaleMessageService localeMessageService;
    private final TeamsService teamsService;

    public SendMessage sendInlineKeyBoardMessage(String chatId){

        var inlineKeyboardMarkup = new InlineKeyboardMarkup();

        var buttonTeam1 = new InlineKeyboardButton();
        var buttonTeam2 = new InlineKeyboardButton();
        var buttonTeam3 = new InlineKeyboardButton();
        var buttonTeam4 = new InlineKeyboardButton();

        buttonTeam1.setText("Natus Vincere");
        buttonTeam1.setCallbackData("TEAMRESULTS_NAVI");

        buttonTeam2.setText("Gambit");
        buttonTeam2.setCallbackData("TEAMRESULTS_GAMBIT");

        buttonTeam3.setText("Astralis");
        buttonTeam3.setCallbackData("TEAMRESULTS_ASTRALIS");

        buttonTeam4.setText("G2");
        buttonTeam4.setCallbackData("TEAMRESULTS_G2");

        inlineKeyboardMarkup.setKeyboard(getInlineKeyboardAsRowsList(
                getInlineButtonsRow(buttonTeam1, buttonTeam2),
                getInlineButtonsRow(buttonTeam3, buttonTeam4)
        ));

        var inlineKeyboardMessage = new SendMessage();
        inlineKeyboardMessage.setChatId(chatId);
        inlineKeyboardMessage.setText(localeMessageService.getMessage("inline.keyboard.teamsResults.greeting_message"));
        inlineKeyboardMessage.setReplyMarkup(inlineKeyboardMarkup);

        return inlineKeyboardMessage;
    }

    public SendMessage teamSubscribeInlineKeyboardOrNotFoundMessage(String teamName, String chatId){
        Optional<Team> team = teamsService.getTeamByName(teamName);
        if(team.isEmpty()){
            return SendMessage.builder()
                    .chatId(chatId)
                    .text("Sorry, team with this name was not found.")
                    .build();
        } else {
            var inlineKeyboardMessage = new SendMessage();
            inlineKeyboardMessage.setChatId(chatId);
            var inlineKeyboardMarkup = new InlineKeyboardMarkup();
                var buttonSubscribe = new InlineKeyboardButton();
                buttonSubscribe.setText("Subscribe to " + team.get().getName());
                String callbackQuery = "SUBSCRIBE_" + team.get().getName();
                buttonSubscribe.setCallbackData(callbackQuery);
                List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
                keyboardButtonsRow1.add(buttonSubscribe);
                List<List<InlineKeyboardButton>> rowsList = new ArrayList<>();
                rowsList.add(keyboardButtonsRow1);
            inlineKeyboardMarkup.setKeyboard(rowsList);
            inlineKeyboardMessage.setReplyMarkup(inlineKeyboardMarkup);
            inlineKeyboardMessage.enableMarkdown(true);

            Formatter messageText = new Formatter();
            messageText.format("* %S *%n%n%s%n%s%n", team.get().getName(), team.get().getCountry(), team.get().getAbbreviation());

            inlineKeyboardMessage.setText(String.valueOf(messageText));
            return inlineKeyboardMessage;
        }
    }
}
