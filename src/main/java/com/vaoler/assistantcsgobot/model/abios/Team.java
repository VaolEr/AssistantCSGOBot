package com.vaoler.assistantcsgobot.model.abios;

import com.vaoler.assistantcsgobot.model.abstractentity.AbstractNamedEntity;

import javax.annotation.Nullable;
import java.util.List;

public class Team extends AbstractNamedEntity {

    private String abbreviation;                            // Team abbreviation
    private List<String> also_known_as;                     // List of alternative names the team use
    private boolean active;                                 // Indicates whether the team is currently active
    @Nullable
    private Region region;                                  // Team geographical belonging information
    private Game game;                                      // The game ID which the team belongs to
    @Nullable
    private String deleted_at;                              // The time when the team was deleted
    private List<Image> images;                             // List of team images
    private List<SocialMediaAccount> social_media_accounts; // List of team social media accounts
    private StandingRoster standing_roster;                 // An ordered list of standing Rosters for the Team, with the most recent one first
    private Organisation  organisation;                     // The organisation ID which the team plays under

}
