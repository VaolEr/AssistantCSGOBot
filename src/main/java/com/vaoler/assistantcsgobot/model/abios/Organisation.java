package com.vaoler.assistantcsgobot.model.abios;

import com.vaoler.assistantcsgobot.model.abstractentity.AbstractNamedEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Nullable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Organisation extends AbstractNamedEntity {

    @Nullable
    private Region region;      // Organisation geographical belonging information
    private List<Team> teams;   // List of team IDs under this organisation

}
