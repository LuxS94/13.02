package org.example._302.excepitions;

import org.example._302.DTO.ErrorsList;
import org.example._302.ErrorsPayload;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ErrorsHandler {
    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorsList handleValidationExceptions(ValidationException ex) {
        return new ErrorsList(ex.getMessage(), LocalDateTime.now(), ex.getErrorMessages());
    }

    ;

    @ExceptionHandler(AlreadyExists.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorsPayload handleBadRequest(AlreadyExists ex) {
        return new ErrorsPayload(ex.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorsPayload handleNotFound(NotFoundException ex) {
        return new ErrorsPayload(ex.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorsPayload handleGenericServerError(Exception ex) {
        ex.printStackTrace();
        return new ErrorsPayload("Ops,c'è stato un errore!", LocalDateTime.now());

    }
}
