package com.vaoler.assistantcsgobot.model.abios;

import com.vaoler.assistantcsgobot.model.abstractentity.AbstractNamedEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Region extends AbstractNamedEntity {

    private String abbreviation;
    private Country country;

}
