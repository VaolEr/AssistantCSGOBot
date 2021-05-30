package com.vaoler.assistantcsgobot.model.abstractentity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class AbstractNamedEntity extends AbstractBaseEntity{

    @NotNull
    @NotBlank
    @Column(name = "name", nullable = false) //для наглядности
    public String name;
}
