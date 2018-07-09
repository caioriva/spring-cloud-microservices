package com.criva.communicationservice.service;

import com.criva.communicationservice.model.dto.MessageCreation;
import com.criva.communicationservice.model.vo.Message;

import java.util.List;

public interface MessageService {

    Message findMessageById(String id);

    Message saveMessage(Message message);

    Message sendMessage(MessageCreation messageCreation);

    Message updateMessage(Message message);

    void deleteMessage(Message message);

    List<Message> findMessagesByRoomId(String roomId);
}
