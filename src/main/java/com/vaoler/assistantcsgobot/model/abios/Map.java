package com.vaoler.assistantcsgobot.model.abios;

import com.vaoler.assistantcsgobot.model.abstractentity.AbstractNamedEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class describes model of Maps object
 * for Abiosgaming.com API
 * @link https://abiosgaming.com/
 *
 * @author ValolEr
 */

@Getter
@Setter
@NoArgsConstructor
public class Map extends AbstractNamedEntity {

    private String external_name;
    private boolean official;
    private GameID game; // The game ID which the map belongs to

}
