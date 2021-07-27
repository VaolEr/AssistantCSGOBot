package com.vaoler.assistantcsgobot.model.bot;

import com.vaoler.assistantcsgobot.model.abstractentity.AbstractBaseEntity;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "User")
@Table(name = "users")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class User extends AbstractBaseEntity {

    @NotNull
    @Column(name = "telegram_chat_id")
    private Long telegramChatId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<UserTeam> userTeams = new ArrayList<>();



    //    @OneToMany(fetch = FetchType.EAGER, mappedBy = "team")
//    private List<Team> teams; //as event_id
}
