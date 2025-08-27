package it.pkg.domain.exception;

public class EntityNotFoundException extends RuntimeException {
      public EntityNotFoundException(String message) {
            super(message);
      }
}
