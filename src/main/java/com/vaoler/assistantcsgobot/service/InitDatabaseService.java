package com.vaoler.assistantcsgobot.service;

import com.vaoler.assistantcsgobot.dto.TeamTo;
import com.vaoler.assistantcsgobot.repository.TeamsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

import static com.vaoler.assistantcsgobot.util.TeamsUtil.getTeamFromTeamTo;

@Service
@RequiredArgsConstructor
public class InitDatabaseService {

    private final SportradarTeamsService sportradarTeamsService;
    private final TeamsRepository teamsRepository;

    @PostConstruct
    public void initTeamsTable(){
        List<TeamTo> teamTos = sportradarTeamsService.sportradarGetTeamsList();
        for(TeamTo teamTo:teamTos){
            String teamApiId = teamTo.getApiId();
            if(teamsRepository.getTeamByApiId(teamApiId).isEmpty()){
                teamsRepository.save(getTeamFromTeamTo(teamTo));
            }
        }

    }
}
