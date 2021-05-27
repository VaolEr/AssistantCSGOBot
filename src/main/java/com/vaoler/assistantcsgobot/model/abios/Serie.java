package com.vaoler.assistantcsgobot.model.abios;

import com.vaoler.assistantcsgobot.model.abstractentity.AbstractBaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Nullable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Serie extends AbstractBaseEntity {

    private String title;                       // Series title
    @Nullable
    private String start;                       // Series start time
    @Nullable
    private String end;                         // Series end time
    private String lifecycle;                   // The lifecycle status of the series (Enum)
    private Integer tier;                       // The internal tier the series is in, 1 being the highest, 2 middle and 3 the lowest.
    private Integer best_of;                    // The maximum number of matches to complete the series
    private List<AbstractBaseEntity> chain;     // An ordered list of Series IDs that are played as a consecutive chain of series, effectively as a Best-of-X-Series
    private boolean streamed;                   // Indicates if the series will be played on stream
    @Nullable
    private BracketPosition bracket_position;   // The bracket position of the series in the substage
    private AbstractBaseEntity tournament;      // The tournament ID which the series belongs to
    private AbstractBaseEntity substage;        // The substage ID which the series belongs to
    private AbstractBaseEntity game;            // The game ID which the series belongs to
    @Nullable
    private String postponed_from;              // The time when the series was originally supposed to be played. null if the series has never been postponed
    @Nullable
    private String deleted_at;                  // The time when the series was deleted
    private List<Participant> participants;     // List of participants competing in the series
    private List<AbstractBaseEntity> matches;   // List of match IDs which the series consists of
    private List<Caster> casters;               // List of casters broadcasting the series ordered by id, with the exception of the primary casters being at index 0.
    private boolean has_incident_report;        // Incidicates if the series has an incident report
}
