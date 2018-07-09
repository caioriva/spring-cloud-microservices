package com.criva.communicationservice.handler.exception;

public class RoomNotFoundException extends RuntimeException{

    public static final String ROOM_NOT_FOUND = "Room Not Found";

    public RoomNotFoundException(String s) {

        super(s);
    }
}
