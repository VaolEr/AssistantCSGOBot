package com.vaoler.assistantcsgobot.dto.abiosTo;

import lombok.Data;

@Data
public class TournamentTo {

    private Integer id;
    private String title;
    private String short_title;
    private Integer tier;
    private TournamentCopyTo copy;
    private TournamentLinksTo links;
    private String start;
    private String end;
    private IdEntityTo game;
    private TournamentPrizePoolTo string_prize_pool;
    private IdEntityTo[] prize_pool;
    private TournamentLocationTo location;
    private String deleted_at;
    private ImageTo[] images;
    private IdEntityTo[] stages;
    private IdEntityTo[] series;
    private IdEntityTo[] rosters;

}
