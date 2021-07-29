package com.vaoler.assistantcsgobot.service;

import com.vaoler.assistantcsgobot.model.bot.Team;
import com.vaoler.assistantcsgobot.model.bot.User;
import com.vaoler.assistantcsgobot.model.bot.UserTeam;
import com.vaoler.assistantcsgobot.repository.UsersTeamsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsersTeamsService {

    private final UsersTeamsRepository usersTeamsRepository;

    @Transactional
    public UserTeam create(UserTeam newUserTeam){
        return usersTeamsRepository.save(newUserTeam);
    }

    @Transactional
    public void unsubscribeUserFromTeam(User user, Team team){
        usersTeamsRepository.deleteUserTeamByTeamIdAndUserId(team.getId(), user.getId());
    }
}
