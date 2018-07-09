package com.criva.communicationservice.handler.exception;

public class MessageNotFoundException extends RuntimeException {

    public static final String MESSAGE_NOT_FOUND = "Message Not Found";

    public MessageNotFoundException(String s) {

        super(s);
    }
}
