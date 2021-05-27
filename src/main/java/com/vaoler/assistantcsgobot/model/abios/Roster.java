package com.vaoler.assistantcsgobot.model.abios;

import com.vaoler.assistantcsgobot.model.abstractentity.AbstractBaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class describes model of Roster object
 * for Abiosgaming.com API
 * @link https://abiosgaming.com/
 *
 * @author ValolEr
 */

@Getter
@Setter
@NoArgsConstructor
public class Roster extends AbstractBaseEntity {

    private Team team; // The team ID of the roster
    private Lineup lineup;
    private Game game; // The game ID which the roster belongs to

}
