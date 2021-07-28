package com.vaoler.assistantcsgobot.bot.keyboards.handlers.callbackquery.types;

/**
 * Callback Query types
 * @author ValolEr
 */
public enum BotCallbackQueryType implements CallbackQueryType {
    TEAMRESULTS("TEAMRESULTS_"),
    SUBSCRIBE("SUBSCRIBE_"),
    UNSUBSCRIBE("UNSUBSCRIBE_"),
    TEAMINFO("TEAMINFO_"),
    TEAMSCHEDULE("TEAMSCHEDULE_"),

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
