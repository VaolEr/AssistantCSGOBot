package com.vaoler.assistantcsgobot.model.abios;

import com.vaoler.assistantcsgobot.model.abstractentity.AbstractBaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Nullable;

@Getter
@Setter
@NoArgsConstructor
public class Caster extends AbstractBaseEntity {

    private String display_name;            // Caster name
    private String username;                // Caster username
    private AbstractBaseEntity game;  // The game ID which the caster belongs to
    @Nullable
    private Platform platform;              // The platform the caster is broadcasting on
    @Nullable
    private Stream stream;                  // The stream the caster is broadcasting on
    @Nullable
    private Region region;                  // Caster geographical belonging information

}
