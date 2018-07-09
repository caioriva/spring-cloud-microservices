package com.criva.communicationservice.service;

import com.criva.communicationservice.client.AccessServiceClient;
import com.criva.communicationservice.handler.exception.RoomNotFoundException;
import com.criva.communicationservice.handler.exception.UnableToCreateRoomForSpecifiedUsersException;
import com.criva.communicationservice.model.dao.RoomDAO;
import com.criva.communicationservice.model.dto.RoomCreation;
import com.criva.communicationservice.model.enumerator.RoleEnum;
import com.criva.communicationservice.model.vo.Participant;
import com.criva.communicationservice.model.vo.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomDAO roomDAO;
    private ParticipantService participantService;
    private AccessServiceClient accessServiceClient;

    @Autowired
    public RoomServiceImpl(RoomDAO roomDAO,
                           ParticipantService participantService,
                           AccessServiceClient accessServiceClient) {

        this.roomDAO = roomDAO;
        this.participantService = participantService;
        this.accessServiceClient = accessServiceClient;
    }

    @Override
    public Room saveRoom(Room room) {

        return roomDAO.save(room);
    }

    @Override
    public Room findRoomByParticipantId(String participantId) {

        return roomDAO.findByParticipantsIdIn(asList(participantId));
    }

    @Override
    public Room findRoomById(String id) {

        return roomDAO.findById(id).orElseThrow(
                () -> new RoomNotFoundException(RoomNotFoundException.ROOM_NOT_FOUND)
        );
    }

    @Override
    public Room createRoom(RoomCreation roomCreation) {

        List<String> allUsersId = new ArrayList<>(roomCreation.getGuestUsersId());
        allUsersId.add(roomCreation.getOwnerUserId());

        if(!accessServiceClient.isAllUsersValid(allUsersId)) {

            throw new UnableToCreateRoomForSpecifiedUsersException(
                    UnableToCreateRoomForSpecifiedUsersException.UNABLE_TO_CREATE_ROOM_FOR_SPECIFIED_USERS);
        }

        List<Participant> participants = new ArrayList<>();

        participants.add(
                new Participant(roomCreation.getOwnerUserId(),
                        RoleEnum.OWNER)
        );

        roomCreation.getGuestUsersId().forEach(
                guest -> participants.add(new Participant(guest, RoleEnum.GUEST))
        );

        List<String> participantsId = participantService.saveParticipants(participants).stream().map(
                        participant -> participant.getId()
        ).collect(Collectors.toList());

        return saveRoom(new Room(roomCreation.getName(), participantsId));
    }
}
