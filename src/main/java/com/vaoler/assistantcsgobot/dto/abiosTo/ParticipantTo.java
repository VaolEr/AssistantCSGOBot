package com.vaoler.assistantcsgobot.dto.abiosTo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantTo {

    @NotNull
    private Integer seed;

    @Nullable
    private Integer score;

    @NotNull
    private Boolean forfeit;

    @NotNull
    private IdEntityTo roster;

    @NotNull
    private Boolean winner;

    @Nullable
    private StatsTo stats;

}
