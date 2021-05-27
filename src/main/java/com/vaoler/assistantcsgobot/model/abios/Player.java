package com.vaoler.assistantcsgobot.model.abios;

import com.vaoler.assistantcsgobot.model.abstractentity.AbstractBaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * This class describes model of Player object
 * for Abiosgaming.com API
 * @link https://abiosgaming.com/
 *
 * @author ValolEr
 */

@Getter
@Setter
@NoArgsConstructor
public class Player extends AbstractBaseEntity {

    private String first_name;
    private String last_name;
    private String nick_name;
    private List<String> also_known_as;
    private boolean active;
    private List<Image> images;
    private GameID game;

}
