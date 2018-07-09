package com.criva.accessservice.handler.exception;

public class UserNameAlreadyTakenException extends RuntimeException {

    public static final String USER_NAME_ALREADY_TAKEN = "User Name Already Taken";

    public UserNameAlreadyTakenException(String s) {

        super(s);
    }
}
