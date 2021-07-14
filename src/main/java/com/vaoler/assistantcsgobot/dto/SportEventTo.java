package com.vaoler.assistantcsgobot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vaoler.assistantcsgobot.model.bot.Team;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties
public class SportEventTo {

    @JsonProperty("id")
    private String apiId;
    private String scheduled;
    @JsonProperty("start_time_tbd")
    private boolean startTimeTbd;
    private String status;
    @JsonProperty("tournament_round")
    private TournamentRoundTo tournamentRound;
    private SeasonTo season;
    private TournamentTo tournament;
    private List<TeamTo> competitors;
    private List<StreamTo> streams;
}
