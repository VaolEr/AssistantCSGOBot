package com.vaoler.assistantcsgobot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PeriodScoreTo {
    @JsonProperty("home_score")
    private Integer homeScore;
    @JsonProperty("away_score")
    private Integer awayScore;
    private String type;
    private Integer number;
}
