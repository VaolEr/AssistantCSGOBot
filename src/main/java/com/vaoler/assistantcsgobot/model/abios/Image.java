package com.vaoler.assistantcsgobot.model.abios;

import com.vaoler.assistantcsgobot.model.abstractentity.AbstractBaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class describes model of Images object
 * for Abiosgaming.com API
 *
 * @author ValolEr
 * @link https://abiosgaming.com/
 */

@Getter
@Setter
@NoArgsConstructor
public class Image extends AbstractBaseEntity {

    private String url;
    private String thumbnail;
    private boolean fallback;
    private String type;

}
