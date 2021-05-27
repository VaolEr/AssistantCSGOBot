package com.vaoler.assistantcsgobot.model.abios;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * This class describes model of GameDefaults object
 * for Abiosgaming.com API
 *
 * @author ValolEr
 * @link https://abiosgaming.com/
 */

@Getter
@Setter
@NoArgsConstructor
public class GameDefaults {

    private String match_type;
    private Map map;
    private Integer lineup_size;
    private String deleted_at;
    private List<Image> images;
    private String color;

}
