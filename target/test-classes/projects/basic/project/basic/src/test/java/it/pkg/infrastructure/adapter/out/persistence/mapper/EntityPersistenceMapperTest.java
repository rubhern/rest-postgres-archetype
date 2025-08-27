package it.pkg.infrastructure.adapter.out.persistence.mapper;

import it.pkg.domain.model.entities.Entity;
import it.pkg.infrastructure.adapter.out.persistence.model.EntityEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class EntityPersistenceMapperTest {

    private final EntityPersistenceMapper mapper = Mappers.getMapper(EntityPersistenceMapper.class);

    @Test
    void should_map_entity_to_domain() {
        // Given
        EntityEntity entity = new EntityEntity();
        entity.setId(1L);

        // When
        Entity entity = mapper.toDomain(entity);

        // Then
        assertEquals(1L, entity.getId());
    }

    @Test
    void should_map_domain_to_entity() {
        // Given
        Entity entity = Entity.builder()
                .id(1L)
                .build();

        // When
        EntityEntity entity = mapper.toEntity(entity);

        // Then
        assertNotNull(entity);
        assertEquals(1L, entity.getId());
    }
}