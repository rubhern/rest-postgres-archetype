package it.pkg.infrastructure.adapter.out.persistence;

import it.pkg.infrastructure.adapter.out.persistence.model.EntityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntityJpaRepository extends JpaRepository<EntityEntity, Long> {

    Optional<EntityEntity> findEntityEntityById(final Long id);
}
