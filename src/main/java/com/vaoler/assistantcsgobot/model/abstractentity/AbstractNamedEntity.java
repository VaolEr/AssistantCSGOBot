package com.vaoler.assistantcsgobot.model.abstractentity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractNamedEntity extends AbstractBaseEntity{
    public String name;
}
