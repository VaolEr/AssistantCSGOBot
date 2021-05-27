package com.vaoler.assistantcsgobot.dto.abiosTo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StreamTo {

    @NotNull
    private Integer id;
    @Nullable
    private String username;        // Stream username on the third party service
    @NotNull
    private String display_name;    // Stream display name
    @Nullable
    private String status_text;     // Brief status text
    @NotNull
    private Integer viewer_count;   // Total viewer count
    @NotNull
    private Boolean online;         // Stream online status
    @Nullable
    private String last_online;     // Indicates when was the stream last seen online
    @NotNull
    private List<ImageTo> images;     // List of external images for the stream containing user logo and stream thumbnail
    @NotNull
    private PlatformTo platform;      // The platform the stream is broadcasted on

}
