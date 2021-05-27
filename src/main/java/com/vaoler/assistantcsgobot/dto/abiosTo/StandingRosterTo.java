package com.vaoler.assistantcsgobot.dto.abiosTo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StandingRosterTo {

    @NotNull
    private Integer id;

    @NotBlank
    private String from;        // The start of the period that this roster was a standing roster
    @Nullable
    private String to;          // The end of the period that this roster was a standing roster
    @NotNull
    private IdEntityTo roster;  // Roster ID
    @Nullable
    private String deleted_at;  // The time when the standing roster was deleted

}
