package com.vaoler.assistantcsgobot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class SportTo {

    String id;
    String name;

}
