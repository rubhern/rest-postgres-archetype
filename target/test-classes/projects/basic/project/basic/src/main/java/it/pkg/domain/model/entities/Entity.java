package it.pkg.domain.model.entities;

import static java.util.Objects.requireNonNull;

public class Entity {

    private final Long id;

    private Entity(Builder builder) {
        this.id = requireNonNull(builder.id, "Id is required");
    }

    // Getters
    public Long getId() { return id; }

    // Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Entity build() {
            return new Entity(this);
        }
    }
}
