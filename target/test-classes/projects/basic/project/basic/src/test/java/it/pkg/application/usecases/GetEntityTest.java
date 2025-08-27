package it.pkg.application.usecases;

import it.pkg.application.query.EntityHandler;
import it.pkg.application.query.EntityQuery;
import it.pkg.domain.exception.EntityNotFoundException;
import it.pkg.domain.model.entities.Entity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GetEntityTest {

    @Mock
    private EntityHandler handler;
    @InjectMocks
    private GetEntity getEntityUseCase;

    @Test
    void should_delegate_to_handler_and_return_result() {
        // Given
        long id = 1L;

        Entity expectedEntity = Entity.builder()
                .id(id)
                .build();

        when(handler.handle(any(EntityQuery.class))).thenReturn(Optional.of(expectedEntity));

        // When
        Entity result = getEntityUseCase.apply(id);

        // Then
        assertEquals(expectedEntity, result);

        verify(handler, times(1)).handle(argThat(query ->
                query.id() == id));
    }

    @Test
    void should_throw_exception_when_no_Entity_found() {
        // Given
        long id = 1L;

        when(handler.handle(any(EntityQuery.class))).thenReturn(Optional.empty());

        // When + Then
        assertThrows(EntityNotFoundException.class, () ->
                getEntityUseCase.apply(id)
        );

        verify(handler, times(1)).handle(any(EntityQuery.class));
    }
}