package com.criva.communicationservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomCreation {

    @NotBlank
    private String name;

    @NotBlank
    private String ownerUserId;

    @NotEmpty
    private List<String> guestUsersId;
}