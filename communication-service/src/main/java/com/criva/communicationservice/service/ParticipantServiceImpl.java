package com.criva.communicationservice.service;

import com.criva.communicationservice.model.dao.ParticipantsDAO;
import com.criva.communicationservice.model.vo.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    private ParticipantsDAO participantsDAO;

    @Autowired
    public ParticipantServiceImpl(ParticipantsDAO participantsDAO) {

        this.participantsDAO = participantsDAO;
    }

    @Override
    public List<Participant> saveParticipants(List<Participant> participants) {

        return participantsDAO.saveAll(participants);
    }

    @Override
    public List<Participant> findParticipantsByIds(List<String> ids) {

        return participantsDAO.findAllByIdIn(ids);
    }
}
