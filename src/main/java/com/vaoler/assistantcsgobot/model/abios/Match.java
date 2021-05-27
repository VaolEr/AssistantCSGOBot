package com.vaoler.assistantcsgobot.model.abios;

import com.vaoler.assistantcsgobot.model.abstractentity.AbstractBaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * This class describes model of Match object
 * for Abiosgaming.com API
 *
 * @author ValolEr
 * @link https://abiosgaming.com/
 */

@Getter
@Setter
@NoArgsConstructor
public class Match extends AbstractBaseEntity {

    private Map map;            // The map ID which the match is played on
    private String lifecycle;
    private Integer order;
    private Serie serie;      //The series ID which the match belongs to
    private String deleted_at;  //The time when the match was deleted
    private Game game;          //The game ID which the match belongs to
    private List<Participant> participants;

}
