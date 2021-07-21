package com.vaoler.assistantcsgobot.service;

import com.vaoler.assistantcsgobot.dto.TeamTo;
import com.vaoler.assistantcsgobot.model.bot.Team;
import com.vaoler.assistantcsgobot.repository.TeamsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.vaoler.assistantcsgobot.util.TeamsUtil.getTeamFromTeamTo;
import static com.vaoler.assistantcsgobot.util.ValidationUtil.*;

@Service
@RequiredArgsConstructor
public class TeamsService {

    private final TeamsRepository teamsRepository;

    public Team getById(Integer teamId){
        return checkNotFound(teamsRepository.findById(teamId),
                addMessageDetails(Team.class.getSimpleName(), teamId));
    }

    public Team getTeamByName(String teamName){
        return checkNotFound(teamsRepository.getTeamByNameIsContainingIgnoreCase(teamName),
                addMessageDetails(Team.class.getSimpleName(), teamName));
    }

    @Transactional
    public Team create(TeamTo teamTo){
        var newTeam = getTeamFromTeamTo(teamTo);
        return teamsRepository.save(newTeam);
    }

    @Transactional
    public Team update(TeamTo teamTo){
        var updatedTeam = getTeamFromTeamTo(teamTo);
        return teamsRepository.save(updatedTeam);
    }

    @Transactional
    public void delete(Integer id) {
        teamsRepository.deleteById(id);
    }


}
