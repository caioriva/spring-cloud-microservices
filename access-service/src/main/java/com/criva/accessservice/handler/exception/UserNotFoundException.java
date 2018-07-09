package com.criva.accessservice.handler.exception;

public class UserNotFoundException extends RuntimeException {

    public static final String USER_NOT_FOUND = "User Not Found";

    public UserNotFoundException(String s) {

        super(s);
    }
}
