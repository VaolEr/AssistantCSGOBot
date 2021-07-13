package com.vaoler.assistantcsgobot.repository;

import com.vaoler.assistantcsgobot.model.bot.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface UsersRepository extends JpaRepository<User,Integer> {

}
