package com.vaoler.assistantcsgobot.model.abios;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class describes model of Stats object
 * for Abiosgaming.com API
 * @link https://abiosgaming.com/
 *
 * @author ValolEr
 */

@Getter
@Setter
@NoArgsConstructor
public class Stats {

    private Integer kills;
    private Integer placement;

}
