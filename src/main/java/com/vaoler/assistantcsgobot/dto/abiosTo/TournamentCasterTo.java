package com.vaoler.assistantcsgobot.dto.abiosTo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TournamentCasterTo {

    private Boolean primary;

    @JsonProperty(value = "default")
    private Boolean defaultVal;

    private IdEntityTo caster;

}
