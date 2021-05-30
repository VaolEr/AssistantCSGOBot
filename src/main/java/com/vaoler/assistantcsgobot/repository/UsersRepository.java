package com.vaoler.assistantcsgobot.repository;

import com.vaoler.assistantcsgobot.model.bot.BotUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface UsersRepository extends JpaRepository<BotUser,Integer> {

}
