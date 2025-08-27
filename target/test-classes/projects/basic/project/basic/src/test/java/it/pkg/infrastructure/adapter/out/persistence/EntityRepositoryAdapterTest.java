package it.pkg.infrastructure.adapter.out.persistence;

import it.pkg.domain.model.entities.Entity;
import it.pkg.infrastructure.adapter.out.persistence.mapper.EntityPersistenceMapper;
import it.pkg.infrastructure.adapter.out.persistence.model.EntityEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EntityRepositoryAdapterTest {

    @Mock
    private EntityJpaRepository jpaRepository;
    @Mock
    private EntityPersistenceMapper mapper;
    @InjectMocks
    private EntityRepositoryAdapter adapter;

    @Test
    void should_return_mapped_Entity() {
        // Given
        Long id = 1L;

        EntityEntity entity = mock(EntityEntity.class);
        Entity entity = mock(Entity.class);

        when(jpaRepository.findEntityEntityById(id)).thenReturn(Optional.of(entity));
        when(mapper.toDomain(entity)).thenReturn(entity);

        // When
        Optional<Entity> result = adapter.findEntity(1L);

        // Then
        assertFalse(result.isEmpty());

        verify(jpaRepository).findEntityEntityById(id);
        verify(mapper).toDomain(entity);
    }
}