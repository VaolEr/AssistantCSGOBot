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
public class RosterTo {

    @NotNull
    private Integer id;
    @Nullable
    private IdEntityTo team;    // The team ID of the roster
    @Nullable
    private LineupTo lineup;    // The lineup of the roster
    @NotNull
    private IdEntityTo game;    // The game ID which the roster belongs to

}
