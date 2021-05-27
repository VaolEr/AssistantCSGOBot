package com.vaoler.assistantcsgobot.dto.abiosTo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrganisationTo {

    @NotNull
    private Integer id;

    @NotBlank
    private String name;

    @Nullable
    private RegionTo region;      // Organisation geographical belonging information

    private List<IdEntityTo> teams;   // List of team IDs under this organisation

}
