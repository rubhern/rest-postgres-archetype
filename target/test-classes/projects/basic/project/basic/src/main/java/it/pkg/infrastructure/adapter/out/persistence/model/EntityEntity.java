package it.pkg.infrastructure.adapter.out.persistence.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Entity")
public class EntityEntity {

    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
