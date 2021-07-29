package com.vaoler.assistantcsgobot.bot.keyboards.abstractkeyboards;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public abstract class AbstractInlineKeyboard extends AbstractKeyboard {

    public abstract SendMessage sendInlineKeyBoardMessage(String chatId);

}
