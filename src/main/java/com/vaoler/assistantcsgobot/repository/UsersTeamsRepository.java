package com.vaoler.assistantcsgobot.repository;

import com.vaoler.assistantcsgobot.model.bot.User;
import com.vaoler.assistantcsgobot.model.bot.UserTeam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersTeamsRepository extends JpaRepository<UserTeam,Integer> {
}
