package it.pkg.application.query;

import it.pkg.domain.model.entities.Entity;
import it.pkg.domain.ports.out.repository.EntityService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EntityHandler {

    private final EntityService entityService;

    public EntityHandler(EntityService entityService) {
        this.entityService = entityService;
    }

    public Optional<Entity> handle(EntityQuery query) {
        return entityService.findEntity(
                query.id());
    }
}
