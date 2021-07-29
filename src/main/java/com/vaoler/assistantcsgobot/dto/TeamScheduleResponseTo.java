package com.vaoler.assistantcsgobot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class TeamScheduleResponseTo {
    @JsonProperty("generated_at")
    private String generatedAt;
    private String schema;
    private TeamTo team;
    private List<SportEventTo> schedule;
}
