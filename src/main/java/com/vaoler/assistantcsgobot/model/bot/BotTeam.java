package com.vaoler.assistantcsgobot.model.bot;

import com.vaoler.assistantcsgobot.model.abstractentity.AbstractNamedEntity;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "BotTeam")
@Table(name = "teams")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class BotTeam extends AbstractNamedEntity {

    @Column(name = "abbreviation")
    String abbreviation;

    @OneToMany(mappedBy = "botTeam", cascade = CascadeType.ALL)
    private Set<BotUserTeam> botUserTeams = new HashSet<>();
}
