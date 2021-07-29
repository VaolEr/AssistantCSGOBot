package com.vaoler.assistantcsgobot.util;


import com.vaoler.assistantcsgobot.dto.TeamTo;
import com.vaoler.assistantcsgobot.model.bot.Team;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TeamsUtil {

    public static Team getTeamFromTeamTo(TeamTo teamTo){
        var newTeam = new Team();
        newTeam.setApiId(teamTo.getApiId());
        newTeam.setName(teamTo.getName());
        newTeam.setCountry(teamTo.getCountry());
        newTeam.setCountryCode(teamTo.getCountryCode());
        newTeam.setAbbreviation(teamTo.getAbbreviation());
        return newTeam;
    }

    public static List<Team> getTeamsFromTeamTos(List<TeamTo> teamTos){
        return teamTos.stream().map(TeamsUtil::getTeamFromTeamTo).collect(Collectors.toList());
    }

    public static TeamTo getTeamToFromTeam(Team team){
        var teamTo = new TeamTo();
        teamTo.setApiId(team.getApiId());
        teamTo.setDbId(team.getId());
        teamTo.setName(team.getName());
        teamTo.setCountry(team.getCountry());
        teamTo.setCountryCode(team.getCountryCode());
        teamTo.setAbbreviation(team.getAbbreviation());
        return teamTo;
    }

    public static List<TeamTo> getTeamTosFromTeams(List<Team> teams){
        return teams.stream().map(TeamsUtil::getTeamToFromTeam).collect(Collectors.toList());
    }
}
