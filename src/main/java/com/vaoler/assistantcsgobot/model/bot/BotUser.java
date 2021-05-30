package com.vaoler.assistantcsgobot.model.bot;

import com.vaoler.assistantcsgobot.model.abstractentity.AbstractBaseEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "BotUser")
@Table(name = "users")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class BotUser extends AbstractBaseEntity {

    @NotNull
    @Column(name = "tg_chat_id")
    private Long tg_chat_id;

    //Todo LIST or SET???
    @OneToMany(mappedBy = "botUser", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<BotUserTeam> botUserTeams = new HashSet<>();


    @OneToMany(mappedBy = "botUser", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<BotUserEvent> botUserEvents = new HashSet<>();
}
