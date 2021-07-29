package com.vaoler.assistantcsgobot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SportEventStatusTo {
    private String status;
    @JsonProperty("match_status")
    private String matchStatus;
    @JsonProperty("home_score")
    private Integer homeScore;
    @JsonProperty("away_score")
    private Integer awayScore;
    @JsonProperty("winner_id")
    private String winnerId;
    @JsonProperty("period_scores")
    private List<PeriodScoreTo> periodScores;
}
