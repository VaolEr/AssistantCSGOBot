package com.vaoler.assistantcsgobot.dto.abiosTo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CountryTo {

    @NotNull
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String abbreviation;
    @NotEmpty
    private List<ImageTo> images;

}
