package com.vaoler.assistantcsgobot.service;

import com.vaoler.assistantcsgobot.dto.abiosTo.TournamentTo;
import com.vaoler.assistantcsgobot.model.bot.BotEvent;
import com.vaoler.assistantcsgobot.repository.BotEventsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static com.vaoler.assistantcsgobot.util.BotEventsUtil.getEventFromTournamentTo;
import static com.vaoler.assistantcsgobot.util.ValidationUtil.*;

@Component //TODO change to service annotation
@RequiredArgsConstructor
public class BotEventsService {

    private final BotEventsRepository botEventsRepository;

    public BotEvent getById(Integer eventId){
        return checkNotFound(botEventsRepository.findById(eventId),
                addMessageDetails(BotEvent.class.getSimpleName(), eventId));
    }

    @Transactional
    public BotEvent create(TournamentTo tournamentTo){
        BotEvent newBotEvent = getEventFromTournamentTo(tournamentTo);
        return botEventsRepository.save(newBotEvent);
    }

    @Transactional
    public BotEvent update(TournamentTo tournamentTo){
        BotEvent updatedBotEvent = getEventFromTournamentTo(tournamentTo);
        assureIdConsistent(updatedBotEvent, tournamentTo.getId());
        return botEventsRepository.save(updatedBotEvent);
    }

    @Transactional
    public void delete(Integer id) {
        botEventsRepository.deleteById(id);
    }
}
