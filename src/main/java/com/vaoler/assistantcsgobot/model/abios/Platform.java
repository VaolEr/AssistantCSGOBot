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
public class Platform extends AbstractNamedEntity {

    @Nullable
    private String color;       // Platform color
    private List<Image> images; // List of platform images

}
