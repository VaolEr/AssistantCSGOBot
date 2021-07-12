package com.vaoler.assistantcsgobot.util;

import com.vaoler.assistantcsgobot.dto.abiosTo.TeamTo;
import com.vaoler.assistantcsgobot.model.bot.BotTeam;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BotTeamsUtil {

    public static BotTeam getBotTeamFromTeamTo(TeamTo teamTo){
        BotTeam botTeam = new BotTeam();

        botTeam.setId(teamTo.getId());
        botTeam.setName(teamTo.getName());
        botTeam.setAbbreviation(teamTo.getAbbreviation());

        return botTeam;
    }

}
