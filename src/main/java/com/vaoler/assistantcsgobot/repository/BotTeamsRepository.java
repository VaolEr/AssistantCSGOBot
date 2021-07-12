package com.vaoler.assistantcsgobot.repository;

import com.vaoler.assistantcsgobot.model.bot.BotTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface BotTeamsRepository extends JpaRepository<BotTeam, Integer> {

}
