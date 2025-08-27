package it.pkg.domain.ports.out.repository;

import it.pkg.domain.model.entities.Entity;

import java.util.Optional;

public interface EntityService {
    Optional<Entity> findEntity(final Long id);
}
