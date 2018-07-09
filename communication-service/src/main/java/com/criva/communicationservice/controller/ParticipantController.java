package com.criva.communicationservice.controller;

import com.criva.communicationservice.model.vo.Participant;
import com.criva.communicationservice.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping(value = "/participants",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class ParticipantController {

    private ParticipantService participantService;

    @Autowired
    public ParticipantController(ParticipantService participantService) {

        this.participantService = participantService;
    }

    @GetMapping(params = "ids")
    @ResponseStatus(HttpStatus.OK)
    public List<Participant> findParticipantsByIds(@NotEmpty @RequestParam("ids") List<String> ids) {

        return participantService.findParticipantsByIds(ids);
    }
}
