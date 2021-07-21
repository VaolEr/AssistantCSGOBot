package com.vaoler.assistantcsgobot.bot.keyboards.abstractkeyboards;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public abstract class AbstractReplyKeyboard extends AbstractKeyboard {

    public abstract SendMessage sendReplyKeyBoardMessage(String chatId);

}
