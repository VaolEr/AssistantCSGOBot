package com.vaoler.assistantcsgobot.model.abstractentity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
@Data
@NoArgsConstructor
@Access(AccessType.FIELD)
public abstract class AbstractBaseEntity implements Persistable<Integer> {

    @Id
    @NotNull
    public Integer id;

    @Override
    public boolean isNew() {
        return null == getId();
    }
}
