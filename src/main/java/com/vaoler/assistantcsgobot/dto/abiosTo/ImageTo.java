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
public class ImageTo {

    @NotNull
    private Integer id;

    @NotBlank
    private String url;         // Image URL

    @NotBlank
    private String thumbnail;   // Thumbnail URL

    @NotNull
    private Boolean fallback;   // Indicates whether this is a fallback image

}
