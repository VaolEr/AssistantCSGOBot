package com.vaoler.assistantcsgobot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CategoryTo {
    @JsonProperty("id")
    private String apiId;
    private String name;
}
