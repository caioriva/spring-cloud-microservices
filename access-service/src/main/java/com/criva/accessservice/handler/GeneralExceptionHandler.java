package com.criva.accessservice.handler;

import com.criva.accessservice.handler.exception.UserNameAlreadyTakenException;
import com.criva.accessservice.handler.exception.UserNotFoundException;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.mongodb.MongoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class GeneralExceptionHandler {

    private static final String DATABASE_ACCESS_ERROR = "Database Access Error";
    private static final String INVALID_ARGUMENTS_ERROR = "Invalid Arguments Error";

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> messageNotFoundExceptionHandler(UserNotFoundException e) {

        return handleException(HttpStatus.NOT_FOUND, e, e.getMessage());
    }

    @ExceptionHandler(UserNameAlreadyTakenException.class)
    public ResponseEntity<?> messageNotFoundExceptionHandler(UserNameAlreadyTakenException e) {

        return handleException(HttpStatus.NOT_FOUND, e, e.getMessage());
    }

    @ExceptionHandler(MongoException.class)
    public ResponseEntity<?> persistenceExceptionHandler(MongoException e) {

        return handleException(HttpStatus.INTERNAL_SERVER_ERROR, e, DATABASE_ACCESS_ERROR);
    }

    @ExceptionHandler(value = {InvalidDefinitionException.class,
            MethodArgumentNotValidException.class,
            ConstraintViolationException.class})
    public ResponseEntity<?> invalidArgumentsExceptionHandler(Exception e) {

        return handleException(HttpStatus.BAD_REQUEST, e, INVALID_ARGUMENTS_ERROR);
    }

    private ResponseEntity<RequestError> handleException(HttpStatus status, Exception e, String message) {

        System.err.println(message);
        e.printStackTrace();

        return new ResponseEntity<>(new RequestError(status.value(), message), status);
    }
}

