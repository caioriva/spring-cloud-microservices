package com.criva.communicationservice.model.dao;

import com.criva.communicationservice.model.vo.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RoomDAO extends MongoRepository<Room, String> {

    Room findByParticipantsIdIn(List<String> ids);
}
