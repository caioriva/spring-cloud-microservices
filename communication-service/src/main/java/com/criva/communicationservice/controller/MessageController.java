package com.criva.communicationservice.controller;

import com.criva.communicationservice.model.dto.MessageCreation;
import com.criva.communicationservice.model.vo.Message;
import com.criva.communicationservice.service.MessageService;
import com.criva.communicationservice.validator.group.AfterSaving;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping(value = "/messages",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class MessageController {

    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {

        this.messageService = messageService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Message findMessageById(@NotBlank @PathVariable("id") String id) {

        return messageService.findMessageById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Message sendMessage(@Valid @RequestBody MessageCreation messageCreation) {

        return messageService.sendMessage(messageCreation);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Message updateMessage(@Validated({AfterSaving.class}) @RequestBody Message message) {

        return messageService.updateMessage(message);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteMessage(@Validated({AfterSaving.class}) @RequestBody Message message){

        messageService.deleteMessage(message);
    }

    @GetMapping(params = "room-id")
    @ResponseStatus(HttpStatus.OK)
    public List<Message> findAllMessgesByRoomId(@RequestParam("room-id") String roomId) {

        return messageService.findMessagesByRoomId(roomId);
    }
}
