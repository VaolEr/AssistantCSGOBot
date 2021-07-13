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
public class Team extends AbstractNamedEntity {

    @Column(name = "api_id")
    String apiId;

    @Column(name = "country")
    String country;

    @Column(name = "country_code")
    String countryCode;

    @Column(name = "abbreviation")
    String abbreviation;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private Set<UserTeam> userTeams = new HashSet<>();
}
