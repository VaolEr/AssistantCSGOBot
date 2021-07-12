package com.vaoler.assistantcsgobot.dto.abiosTo;

import lombok.Data;

@Data
public class TournamentLocationTo {

    private HostTo host;
    private ParticipantTo[] participants;

}
