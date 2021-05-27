package com.vaoler.assistantcsgobot.dto.abiosTo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeamTo {

    @NotNull
    private Integer id;                                         // Team id
    @NotBlank
    private String name;                                        // Team name
    @NotBlank
    private String abbreviation;                                // Team abbreviation
    @NotEmpty
    private List<String> also_known_as;                         // List of alternative names the team use
    @NotNull
    private Boolean active;                                     // Indicates whether the team is currently active
    @Nullable
    private RegionTo region;                                      // Team geographical belonging information
    @NotNull
    private IdEntityTo game;                                    // The game ID which the team belongs to
    @Nullable
    private String deleted_at;                                  // The time when the team was deleted
    private List<ImageTo> images;                               // List of team images
    private List<SocialMediaAccountTo> social_media_accounts;   // List of team social media accounts
    @Nullable
    private StandingRosterTo standing_roster;                   // An ordered list of standing Rosters for the Team, with the most recent one first
    @Nullable
    private IdEntityTo  organisation;                           // The organisation ID which the team plays under

}
