package com.vaoler.assistantcsgobot.model.bot;


import com.vaoler.assistantcsgobot.model.abstractentity.AbstractBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "UserTeam")
@Table(name = "users_teams")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class UserTeam extends AbstractBaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "team_id")
    private Team team;

}
