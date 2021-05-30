package com.vaoler.assistantcsgobot.repository;

import com.vaoler.assistantcsgobot.model.bot.BotEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface EventsRepository extends JpaRepository<BotEvent, Integer> {

}
