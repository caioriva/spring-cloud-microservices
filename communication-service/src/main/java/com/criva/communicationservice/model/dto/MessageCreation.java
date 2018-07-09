package com.criva.communicationservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageCreation {

    @NotBlank
    private String text;

    @NotBlank
    private String senderParticipantId;
}