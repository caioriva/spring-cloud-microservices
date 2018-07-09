package com.criva.communicationservice.service;

import com.criva.communicationservice.model.dto.RoomCreation;
import com.criva.communicationservice.model.vo.Room;

public interface RoomService {

    Room saveRoom(Room room);

    Room findRoomByParticipantId(String participantId);

    Room findRoomById(String id);

    Room createRoom(RoomCreation roomCreation);
}