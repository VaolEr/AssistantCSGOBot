package com.vaoler.assistantcsgobot.service;

import com.vaoler.assistantcsgobot.dto.TeamTo;
import com.vaoler.assistantcsgobot.model.bot.BotTeam;
import com.vaoler.assistantcsgobot.repository.BotTeamsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static com.vaoler.assistantcsgobot.util.BotTeamsUtil.getBotTeamFromTeamTo;
import static com.vaoler.assistantcsgobot.util.ValidationUtil.*;

@Component //TODO change to service annotation
@RequiredArgsConstructor
public class BotTeamsService {

    private final BotTeamsRepository botTeamsRepository;

    public BotTeam getById(Integer teamId){
        return checkNotFound(botTeamsRepository.findById(teamId),
                addMessageDetails(BotTeam.class.getSimpleName(), teamId));
    }

    @Transactional
    public BotTeam create(TeamTo teamTo){
        BotTeam newBotTeam = getBotTeamFromTeamTo(teamTo);
        return botTeamsRepository.save(newBotTeam);
    }

    @Transactional
    public BotTeam update(TeamTo teamTo){
        BotTeam updatedBotTeam = getBotTeamFromTeamTo(teamTo);
        //assureIdConsistent(updatedBotTeam, teamTo.getId());
        return botTeamsRepository.save(updatedBotTeam);
    }

    @Transactional
    public void delete(Integer id) {
        botTeamsRepository.deleteById(id);
    }


}
