package com.vaoler.assistantcsgobot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SeasonTo extends AbstractNamedTo{
    //@JsonProperty("id")
//    private String apiId;
//    private String name;
    @JsonProperty("start_date")
    private String startDate;
    @JsonProperty("end_date")
    private String endDate;
    private String year;
    @JsonProperty("tournament_id")
    private String tournamentId;
}
