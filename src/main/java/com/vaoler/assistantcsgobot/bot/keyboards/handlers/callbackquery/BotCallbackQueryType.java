package com.vaoler.assistantcsgobot.bot.keyboards.handlers.callbackquery;

/**
 * Callback Query types
 * @author ValolEr
 */
public enum BotCallbackQueryType implements CallbackQueryType {
    TEAMRESULTS("TEAMRESULTS_"),
    SUBSCRIBE("SUBSCRIBE_"),
    TEAMINFO("TEAMINFO_"),

    IMPLEMENTED$TEST("IMPLEMENTED$TEST_"),
    NOT$IMPLEMENTED$("NOT$IMPLEMENTED$_");

    private final String queryTypeAsString;
    BotCallbackQueryType(String queryTypeAsString){
        this.queryTypeAsString = queryTypeAsString;
    }

    public String getQueryTypeAsString() {
        return queryTypeAsString;
    }
}
