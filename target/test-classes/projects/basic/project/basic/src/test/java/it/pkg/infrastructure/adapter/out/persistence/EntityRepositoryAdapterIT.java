package it.pkg.infrastructure.adapter.out.persistence;

import it.pkg.domain.model.entities.Entity;
import it.pkg.domain.ports.out.repository.EntityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class EntityRepositoryAdapterIT {

    @Autowired
    private EntityService adapter;

    @Test
    void should_return_Entity_from_database() {
        // Given
        Long id = 1L;

        // When
        Optional<Entity> optionalEntity = adapter.findEntity(id);

        // Then
        assertFalse(optionalEntity.isEmpty());
        Entity entity = optionalEntity.get();
        assertEquals(id, entity.getId());
    }
}
