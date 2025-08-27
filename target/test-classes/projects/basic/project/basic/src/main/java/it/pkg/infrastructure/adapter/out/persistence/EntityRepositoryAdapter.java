package it.pkg.infrastructure.adapter.out.persistence;

import it.pkg.domain.model.entities.Entity;
import it.pkg.domain.ports.out.repository.EntityService;
import it.pkg.infrastructure.adapter.out.persistence.mapper.EntityPersistenceMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EntityRepositoryAdapter implements EntityService {

    private final EntityJpaRepository jpaRepository;
    private final EntityPersistenceMapper mapper;

     public EntityRepositoryAdapter(EntityJpaRepository jpaRepository, EntityPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Entity> findEntity(Long id) {
        return jpaRepository.findEntityEntityById(id)
                .map(mapper::toDomain);
    }
}
