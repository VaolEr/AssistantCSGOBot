package com.vaoler.assistantcsgobot.model.abios;

import com.vaoler.assistantcsgobot.model.abstractentity.AbstractBaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Nullable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Stream extends AbstractBaseEntity {

    @Nullable
    private String username;        // Stream username on the third party service
    private String display_name;    // Stream display name
    @Nullable
    private String status_text;     // Brief status text
    private Integer viewer_count;   // Total viewer count
    private boolean online;         // Stream online status
    @Nullable
    private String last_online;     // Indicates when was the stream last seen online
    private List<Image> images;     // List of external images for the stream containing user logo and stream thumbnail
    private Platform platform;      // The platform the stream is broadcasted on

}
