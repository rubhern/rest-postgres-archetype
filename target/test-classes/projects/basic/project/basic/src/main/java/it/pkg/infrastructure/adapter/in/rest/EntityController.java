package it.pkg.infrastructure.adapter.in.rest;

import it.pkg.application.usecases.GetEntity;
import it.pkg.infrastructure.adapter.in.rest.api.EntitysApi;
import it.pkg.infrastructure.adapter.in.rest.dto.EntityResponse;
import it.pkg.infrastructure.adapter.in.rest.mapper.EntityRestMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntityController implements EntitysApi {

    private final GetEntity getEntity;
    private final EntityRestMapper entityRestMapper;

    public EntityController(GetEntity getEntity, EntityRestMapper entityRestMapper) {
        this.getEntity = getEntity;
        this.entityRestMapper = entityRestMapper;
    }

    @Override
    public ResponseEntity<EntityResponse> getEntityById(Long id) {
        var entity = getEntity.apply(id);
        return ResponseEntity.ok(entityRestMapper.toResponse(entity));
    }
}
