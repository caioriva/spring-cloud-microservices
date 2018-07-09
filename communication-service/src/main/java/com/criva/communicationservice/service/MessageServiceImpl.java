package com.criva.communicationservice.service;

import com.criva.communicationservice.handler.exception.MessageNotFoundException;
import com.criva.communicationservice.handler.exception.RoomNotFoundException;
import com.criva.communicationservice.model.dao.MessageDAO;
import com.criva.communicationservice.model.dto.MessageCreation;
import com.criva.communicationservice.model.vo.Context;
import com.criva.communicationservice.model.vo.Message;
import com.criva.communicationservice.model.vo.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService{

    private MessageDAO messageDAO;
    private RoomService roomService;
    private ContextService contextService;

    @Autowired
    public MessageServiceImpl(MessageDAO messageDAO, RoomService roomService, ContextService contextService) {

        this.messageDAO = messageDAO;
        this.roomService = roomService;
        this.contextService = contextService;
    }

    @Override
    public Message findMessageById(String id) {

        return messageDAO.findById(id).orElseThrow(
                () -> new MessageNotFoundException(MessageNotFoundException.MESSAGE_NOT_FOUND)
        );
    }

    @Override
    public Message saveMessage(Message message) {

        return messageDAO.save(message);
    }

    @Override
    public Message sendMessage(MessageCreation messageCreation) {

        Room room = roomService.findRoomByParticipantId(messageCreation.getSenderParticipantId());

        if(room == null) {

            throw  new RoomNotFoundException(RoomNotFoundException.ROOM_NOT_FOUND);
        }

        List<String> contextsId = contextService.saveContexts(
                room.getParticipantsId().stream().map(
                        id -> new Context(id, Boolean.TRUE, Boolean.FALSE)
                ).collect(Collectors.toList())
        ).stream().map(
                context -> context.getId()
        ).collect(Collectors.toList());

        return saveMessage(
                new Message(messageCreation.getText(),
                        Instant.now(),
                        Boolean.TRUE,
                        messageCreation.getSenderParticipantId(),
                        contextsId
                )
        );
    }

    @Override
    public Message updateMessage(Message message) {

        return messageDAO.save(message);
    }

    @Override
    public void deleteMessage(Message message) {

        messageDAO.delete(message);
    }

    @Override
    public List<Message> findMessagesByRoomId(String roomId) {

        Room room = roomService.findRoomById(roomId);

        return messageDAO.findAllBySenderParticipantIdIn(room.getParticipantsId());
    }
}
