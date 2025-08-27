package it.pkg.application.usecases;

import it.pkg.application.query.EntityHandler;
import it.pkg.application.query.EntityQuery;
import it.pkg.domain.exception.EntityNotFoundException;
import it.pkg.domain.model.entities.Entity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.function.LongFunction;

@Component
public class GetEntity implements LongFunction<Entity> {

    private static final Logger log = LoggerFactory.getLogger(GetEntity.class);
    private final EntityHandler handler;

    public GetEntity(EntityHandler handler) {
        this.handler = handler;
    }

    @Override
    public Entity apply(long id) {
    EntityQuery query = new EntityQuery(id);

        return handler.handle(query).orElseThrow(() -> {
            log.warn("No Entity found for id={}", id);
            return new EntityNotFoundException("No Entity found for id=" + id);
        });
    }
}
