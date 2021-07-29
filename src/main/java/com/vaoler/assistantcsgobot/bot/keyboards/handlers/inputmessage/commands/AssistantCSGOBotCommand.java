package com.vaoler.assistantcsgobot.bot.keyboards.handlers.inputmessage.commands;

import com.vaoler.assistantcsgobot.bot.keyboards.handlers.inputmessage.commands.TelegramBotCommand;

import java.util.HashMap;
import java.util.Map;

public enum AssistantCSGOBotCommand implements TelegramBotCommand {
    START("/start"),
    HELP("/help"),
    FINDTEAM("/findteam"),
    MYSUBS("/mysubs"),

    NOT$IMPLEMENTED$("/not$implemented$");

    private final String telegramBotCommand;

    private static final Map<String, AssistantCSGOBotCommand> map;
    static {
        map = new HashMap<String, AssistantCSGOBotCommand>();
        for (AssistantCSGOBotCommand v : AssistantCSGOBotCommand.values()) {
            map.put(v.telegramBotCommand, v);
        }
    }
    public static AssistantCSGOBotCommand findByTelegramBotCommand(String telegramBotCommand) {
        return map.get(telegramBotCommand);
    }

    AssistantCSGOBotCommand(String telegramBotCommand){
        this.telegramBotCommand = telegramBotCommand;
    }

    public String getTelegramBotCommand() {
        return telegramBotCommand;
    }

}
