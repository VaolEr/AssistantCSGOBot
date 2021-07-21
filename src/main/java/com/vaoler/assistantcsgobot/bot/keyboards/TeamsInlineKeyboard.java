package com.vaoler.assistantcsgobot.bot.keyboards;

import com.vaoler.assistantcsgobot.bot.keyboards.abstractkeyboards.AbstractInlineKeyboard;
import com.vaoler.assistantcsgobot.service.LocaleMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

@Component
@RequiredArgsConstructor
public class TeamsInlineKeyboard extends AbstractInlineKeyboard {

    private final LocaleMessageService localeMessageService;

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

}
