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

public class SocialMediaAccountTo {

    @NotBlank
    private String handle;                      // The social media account handle

    @NotBlank
    private String url;                         // The social media account URL

    @NotNull
    private SocialMediaPlatformTo platform;     // The platform which the social media account belongs to

}
