package it.pkg.application.query;

import it.pkg.domain.model.entities.Entity;
import it.pkg.domain.ports.out.repository.EntityService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EntityHandlerTest {

    @Mock
    private EntityService repository;
    @InjectMocks
    private EntityHandler handler;

    private static EntityQuery query;

    @BeforeAll
    public static void setUp() {
        query = new EntityQuery(1L);
    }

    @Test
    void should_return_Entity() {
        // Given
        Entity entity = Entity.builder()
                .id(1L)
                .build();

        when(repository.findEntity(1L)).thenReturn(Optional.of(entity));

        // When
        Optional<Entity> result = handler.handle(query);

        // Then
        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
    }

    @Test
    void should_return_empty_if_no_applicable_Entity() {
        // Given
        when(repository.findEntity(1L)).thenReturn(Optional.empty());

        // When
        Optional<Entity> result = handler.handle(query);

        // Then
        assertTrue(result.isEmpty());
    }
}