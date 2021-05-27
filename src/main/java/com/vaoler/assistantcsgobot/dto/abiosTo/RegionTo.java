package com.vaoler.assistantcsgobot.dto.abiosTo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegionTo {

    @NotNull
    private Integer id;
    @NotBlank
    private String name;
    @NotNull
    private String abbreviation;
    @NotNull
    private CountryTo country;

}
