package com.vaoler.assistantcsgobot.model.abstractentity;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public abstract class AbstractBaseEntity {

    @NotNull
    public Integer id;

}
