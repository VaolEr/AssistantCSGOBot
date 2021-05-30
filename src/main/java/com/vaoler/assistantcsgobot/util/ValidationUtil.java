package com.vaoler.assistantcsgobot.util;

import com.vaoler.assistantcsgobot.model.abstractentity.AbstractBaseEntity;
import com.vaoler.assistantcsgobot.util.exception.IllegalRequestDataException;
import com.vaoler.assistantcsgobot.util.exception.NotFoundException;

import javax.validation.constraints.NotNull;
import java.util.Optional;

public class ValidationUtil {

    public static <T> T checkNotFound(@NotNull Optional<T> optional, String msg) {
        return optional.orElseThrow(() -> new NotFoundException("Not found entity with " + msg));
    }

    public static String addMessageDetails(String entityType, String identifier) {
        return String.format("type is '%s' and identifier is '%s'", entityType, identifier);
    }

    public static String addMessageDetails(String entityType, Integer entityId) {
        return addMessageDetails(entityType, entityId.toString());
    }

    public static <E extends AbstractBaseEntity> void assureIdConsistent(E entity, Integer id) {
        // http://stackoverflow.com/a/32728226/548473
        if (entity.isNew()) {
            entity.setId(id);
        } else {
            assert entity.getId() != null;
            if (!entity.getId().equals(id)) {
                throw new IllegalRequestDataException(entity + " must be with id = " + id);
            }
        }
    }
}
