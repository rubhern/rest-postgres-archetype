package it.pkg.infrastructure.adapter.in.rest.mapper;

import it.pkg.domain.model.entities.Entity;
import it.pkg.infrastructure.adapter.in.rest.dto.EntityResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EntityRestMapperTest {
    private final EntityRestMapper mapper = new EntityRestMapperImpl();

    @Test
    void should_map_Entity_entity_to_response_dto_correctly() {
        // Given
        Entity entity = Entity.builder()
                .id(1L)
                .build();

        // When
        EntityResponse response = mapper.toResponse(entity);

        // Then
        assertEquals(1L, response.getId());
    }
}