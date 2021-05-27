package com.vaoler.assistantcsgobot.model.abios;

import com.vaoler.assistantcsgobot.model.abstractentity.AbstractBaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class describes model of Games object
 * for Abiosgaming.com API
 * @link https://abiosgaming.com/
 *
 * @author ValolEr
 */

@Getter
@Setter
@NoArgsConstructor
public class Game extends AbstractBaseEntity {

    private String abbreviation;
    private String title;
    private String default_match_type;
    private Map default_map;
    private GameDefaults defaults;
    private String deleted_at;

}
