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
public class CasterTo {

    @NotNull
    private Integer id;
    @NotNull
    private String display_name;            // Caster name
    @NotNull
    private String username;                // Caster username
    @NotNull
    private IdEntityTo game;                // The game ID which the caster belongs to
    @Nullable
    private PlatformTo platform;              // The platform the caster is broadcasting on
    @Nullable
    private StreamTo stream;                  // The stream the caster is broadcasting on
    @Nullable
    private RegionTo region;                  // Caster geographical belonging information

}
