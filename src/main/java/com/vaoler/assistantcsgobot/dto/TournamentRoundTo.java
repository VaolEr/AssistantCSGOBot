package com.vaoler.assistantcsgobot.dto;

import lombok.Data;

@Data
public class TournamentRoundTo extends AbstractBaseTo{

//    //@JsonProperty("id")
//    private String apiId;
    private String type;
    private Integer number;
    private String group;
}
