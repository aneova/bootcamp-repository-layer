package org.schwarz.bootcamp.spring.servicelayer.service.validation.exception;

public class StoreDataInvalidException extends RuntimeException {
    private static final String MESSAGE = String.format("There is invalid store data.");

    public StoreDataInvalidException() {
        super(MESSAGE);
    }
}
