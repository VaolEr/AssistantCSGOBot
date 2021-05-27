package com.vaoler.assistantcsgobot.model.abios;

import com.vaoler.assistantcsgobot.model.abstractentity.AbstractBaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Nullable;

@Getter
@Setter
@NoArgsConstructor
public class StandingRoster extends AbstractBaseEntity {


    private String from;        // The start of the period that this roster was a standing roster
    @Nullable
    private String to;          // The end of the period that this roster was a standing roster
    private Roster roster;      // Roster ID
    @Nullable
    private String deleted_at;  // The time when the standing roster was deleted
}
