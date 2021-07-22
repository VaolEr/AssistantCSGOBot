package com.vaoler.assistantcsgobot.repository;

import com.vaoler.assistantcsgobot.model.bot.Team;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface TeamsRepository extends JpaRepository<Team, Integer> {

    Optional<Team> getTeamByApiId(String apiId);

    Optional<Team> getTeamByNameIsContaining(String teamName);

    Optional<Team> getTeamByNameIsContainingIgnoreCase(String teamName);

    Optional<Team> getTeamByName(String teamName);
}
