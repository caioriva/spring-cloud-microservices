package com.criva.communicationservice.controller;

import com.criva.communicationservice.model.dto.RoomCreation;
import com.criva.communicationservice.model.vo.Room;
import com.criva.communicationservice.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/rooms",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class RoomController {

    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {

        this.roomService = roomService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Room createRoom(@Valid @RequestBody RoomCreation roomCreation) {

        return roomService.createRoom(roomCreation);
    }
}
