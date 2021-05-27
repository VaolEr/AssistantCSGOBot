package com.vaoler.assistantcsgobot.model.abios;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class describes model of Participant object
 * for Abiosgaming.com API
 *
 * @author ValolEr
 * @link https://abiosgaming.com/
 */

@Getter
@Setter
@NoArgsConstructor
public class Participant {

    private Integer seed;
    private Integer score;
    private boolean forfeit;
    private Roster roster;
    private boolean winner;
    private Stats stats;

}
