package com.vaoler.assistantcsgobot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties
public class TeamsListGetResponse {
    String generated_at;
    String schema;
    SportTo sport;
    List<TeamTo> teams;
}

