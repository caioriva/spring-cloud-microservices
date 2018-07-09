package com.criva.communicationservice.service;

import com.criva.communicationservice.model.vo.Participant;

import java.util.List;

public interface ParticipantService {

    List<Participant> saveParticipants(List<Participant> participants);

    List<Participant> findParticipantsByIds(List<String> ids);
}
