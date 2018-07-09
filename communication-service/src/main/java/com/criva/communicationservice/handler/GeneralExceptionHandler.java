package com.criva.communicationservice.handler;

import com.criva.communicationservice.handler.exception.MessageNotFoundException;
import com.criva.communicationservice.handler.exception.RoomNotFoundException;
import com.criva.communicationservice.handler.exception.UnableToCreateRoomForSpecifiedUsersException;
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

    @ExceptionHandler(MessageNotFoundException.class)
    public ResponseEntity<?> messageNotFoundExceptionHandler(MessageNotFoundException e) {

        return handleException(HttpStatus.NOT_FOUND, e, e.getMessage());
    }

    @ExceptionHandler(RoomNotFoundException.class)
    public ResponseEntity<?> roomNotFoundExceptionHandler(RoomNotFoundException e) {

        return handleException(HttpStatus.NOT_FOUND, e, e.getMessage());
    }

    @ExceptionHandler(UnableToCreateRoomForSpecifiedUsersException.class)
    public ResponseEntity<?> unableToCreateRoomForSpecifiedUsersExceptionHandler(
            UnableToCreateRoomForSpecifiedUsersException e) {

        return handleException(HttpStatus.INTERNAL_SERVER_ERROR, e, e.getMessage());
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
