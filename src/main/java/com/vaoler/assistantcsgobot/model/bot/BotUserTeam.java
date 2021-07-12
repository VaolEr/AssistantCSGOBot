package com.vaoler.assistantcsgobot.model.bot;


import com.vaoler.assistantcsgobot.model.abstractentity.AbstractBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "BotUserTeam")
@Table(name = "users_teams")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class BotUserTeam extends AbstractBaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private BotUser botUser;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "team_id")
    private BotTeam botTeam;

}
