package com.vaoler.assistantcsgobot.model.bot;

import com.vaoler.assistantcsgobot.model.abstractentity.AbstractBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity(name = "BotEvent")
@Table(name = "events")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class BotEvent extends AbstractBaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "tier")
    private Integer tier;

    @OneToMany(mappedBy = "botEvent", cascade = CascadeType.ALL)
    private Set<BotUserEvent> botUserEvents = new HashSet<>();

}
