package com.criva.communicationservice.handler.exception;

public class UnableToCreateRoomForSpecifiedUsersException extends RuntimeException {

    public static final String UNABLE_TO_CREATE_ROOM_FOR_SPECIFIED_USERS = "Unable To Create Room For Specified Users";

    public UnableToCreateRoomForSpecifiedUsersException(String s) {

        super(s);
    }
}
