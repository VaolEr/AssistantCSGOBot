package com.vaoler.assistantcsgobot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class DailyScheduleTo {

    @JsonProperty("generated_at")
    private String generatedAt;
    private String schema;
    @JsonProperty("sport_events")
    private List<SportEventTo> sportEvents;

}
