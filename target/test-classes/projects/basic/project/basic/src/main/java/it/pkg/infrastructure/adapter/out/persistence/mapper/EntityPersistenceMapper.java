package it.pkg.infrastructure.adapter.out.persistence.mapper;


import it.pkg.domain.model.entities.Entity;
import it.pkg.infrastructure.adapter.out.persistence.model.EntityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface EntityPersistenceMapper {

    Entity toDomain(EntityEntity entity);

    EntityEntity toEntity(Entity entity);
}
