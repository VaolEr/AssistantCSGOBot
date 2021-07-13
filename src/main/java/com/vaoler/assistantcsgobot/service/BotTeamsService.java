package com.vaoler.assistantcsgobot.service;

import com.vaoler.assistantcsgobot.dto.TeamTo;
import com.vaoler.assistantcsgobot.model.bot.Team;
import com.vaoler.assistantcsgobot.repository.TeamsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static com.vaoler.assistantcsgobot.util.TeamsUtil.getTeamFromTeamTo;
import static com.vaoler.assistantcsgobot.util.ValidationUtil.*;

@Component //TODO change to service annotation
@RequiredArgsConstructor
public class BotTeamsService {

    private final TeamsRepository teamsRepository;

    public Team getById(Integer teamId){
        return checkNotFound(teamsRepository.findById(teamId),
                addMessageDetails(Team.class.getSimpleName(), teamId));
    }

    @Transactional
    public Team create(TeamTo teamTo){
        Team newTeam = getTeamFromTeamTo(teamTo);
        return teamsRepository.save(newTeam);
    }

    @Transactional
    public Team update(TeamTo teamTo){
        Team updatedTeam = getTeamFromTeamTo(teamTo);
        //assureIdConsistent(updatedBotTeam, teamTo.getId());
        return teamsRepository.save(updatedTeam);
    }

    @Transactional
    public void delete(Integer id) {
        teamsRepository.deleteById(id);
    }


}
