package com.criva.communicationservice.model.dao;

import com.criva.communicationservice.model.vo.Participant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ParticipantsDAO extends MongoRepository<Participant, String> {

    List<Participant> findAllByIdIn(List<String> ids);
}