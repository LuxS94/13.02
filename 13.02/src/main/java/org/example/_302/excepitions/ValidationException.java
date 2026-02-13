package org.example._302.excepitions;

import lombok.Getter;

import java.util.List;

@Getter
public class ValidationException extends RuntimeException {
    private List<String> errorMessages;

    public ValidationException(List<String> errorMessages) {
        super("Errori nel payload");
        this.errorMessages = errorMessages;
    }
}