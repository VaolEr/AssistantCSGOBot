package com.vaoler.assistantcsgobot.model.abios;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SocialMediaAccount {
    private String handle;
    private String url;
    private SocialMediaPlatform platform;
}
