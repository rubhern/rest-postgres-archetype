package it.pkg.infrastructure.adapter.in.rest;

import it.pkg.application.usecases.GetEntity;
import it.pkg.domain.model.entities.Entity;
import it.pkg.infrastructure.adapter.in.rest.dto.EntityResponse;
import it.pkg.infrastructure.adapter.in.rest.mapper.EntityRestMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EntityControllerTest {

    @Mock
    private GetEntity service;

    @Mock
    private EntityRestMapper mapper;

    @InjectMocks
    private EntityController controller;

    @Test
    void should_return_response_when_Entity_found() {
        // Given
        long id = 1L;

        Entity entity = mock(Entity.class);
        EntityResponse response = mock(EntityResponse.class);

        when(service.apply(id)).thenReturn(entity);
        when(mapper.toResponse(entity)).thenReturn(response);

        // When
        ResponseEntity<EntityResponse> result = controller.getEntityById(id);

        // Then
        assertEquals(200, result.getStatusCode().value());
        assertEquals(response, result.getBody());
    }
}