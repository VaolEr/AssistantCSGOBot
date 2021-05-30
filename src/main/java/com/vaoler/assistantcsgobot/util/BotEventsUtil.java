package com.vaoler.assistantcsgobot.util;

import com.vaoler.assistantcsgobot.dto.abiosTo.TournamentTo;
import com.vaoler.assistantcsgobot.model.bot.BotEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BotEventsUtil {

    public static BotEvent getEventFromTournamentTo(TournamentTo tournamentTo){
        BotEvent botEvent = new BotEvent();
        botEvent.setId(tournamentTo.getId());
        botEvent.setTitle(tournamentTo.getTitle());
        botEvent.setTier(tournamentTo.getTier());
        return botEvent;
    }

}
