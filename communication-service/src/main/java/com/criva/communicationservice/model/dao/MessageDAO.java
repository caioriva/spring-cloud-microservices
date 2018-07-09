package com.criva.communicationservice.model.dao;

import com.criva.communicationservice.model.vo.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageDAO extends MongoRepository<Message, String> {

    List<Message> findAllBySenderParticipantIdIn(List<String> senderParticipantsIds);
}
