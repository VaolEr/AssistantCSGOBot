package com.vaoler.assistantcsgobot.model.bot;

import com.vaoler.assistantcsgobot.model.abstractentity.AbstractBaseEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "User")
@Table(name = "users")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class User extends AbstractBaseEntity {

    @NotNull
    @Column(name = "telegram_chat_id")
    private Long telegramChatId;

    //Todo LIST or SET???
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<UserTeam> userTeams = new HashSet<>();

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "team")
//    private List<Team> teams; //as event_id
}
