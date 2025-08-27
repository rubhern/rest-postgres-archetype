package it.pkg.infrastructure.adapter.in.rest.mapper;

import it.pkg.domain.model.entities.Entity;
import it.pkg.infrastructure.adapter.in.rest.dto.EntityResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntityRestMapper {

    EntityResponse toResponse(Entity entity);
}
