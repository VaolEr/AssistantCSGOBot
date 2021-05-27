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
public class SocialMediaPlatformTo {

    @NotNull
    private Integer id;     // Platform id

    @NotBlank
    private String name;    // Platform name

    @NotBlank
    private String slug;    // Platform slug

}
