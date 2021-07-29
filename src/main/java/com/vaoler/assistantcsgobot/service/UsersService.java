package com.vaoler.assistantcsgobot.service;

import com.vaoler.assistantcsgobot.model.bot.User;
import com.vaoler.assistantcsgobot.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.vaoler.assistantcsgobot.util.ValidationUtil.addMessageDetails;
import static com.vaoler.assistantcsgobot.util.ValidationUtil.checkNotFound;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;

    public User getById(Integer userId){
        return checkNotFound(usersRepository.findById(userId),
                addMessageDetails(User.class.getSimpleName(), userId));
    }

    public Optional<User> getUserByTelegramChatId(Long telegramChatId){
        return usersRepository.getUserByTelegramChatId(telegramChatId);
//        return checkNotFound(usersRepository.getUserByTelegramChatId(telegramChatId),
//                addMessageDetails(User.class.getSimpleName(), telegramChatId.toString()));
    }

    @Transactional
    public User create(User newUser){
        return usersRepository.save(newUser);
    }

    @Transactional
    public User update(User updatedUser){
        return usersRepository.save(updatedUser);
    }

    @Transactional
    public void delete(Integer id) {
        usersRepository.deleteById(id);
    }


}
