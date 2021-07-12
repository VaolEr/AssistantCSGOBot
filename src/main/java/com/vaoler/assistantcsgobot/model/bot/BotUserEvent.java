package com.vaoler.assistantcsgobot.model.bot;

import com.vaoler.assistantcsgobot.model.abstractentity.AbstractBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "BotUserEvent")
@Table(name = "users_events")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class BotUserEvent extends AbstractBaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private BotUser botUser;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "event_id")
    private BotEvent botEvent;

}
