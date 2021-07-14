package com.vaoler.assistantcsgobot.dto;


import lombok.Data;

@Data
public class TournamentTo extends AbstractNamedTo{
//    //@JsonProperty("id")
//    private String apiId;
//    private String name;
    private SportTo sport;
    private CategoryTo category;

}
