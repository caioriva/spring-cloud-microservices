package com.criva.communicationservice.model.vo;

import com.criva.communicationservice.validator.group.AfterSaving;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;

@Document(collection = "message")
@Getter
@Setter
@NoArgsConstructor
public class Message {

    @Id
    @NotBlank(groups = {AfterSaving.class})
    private String id;

    @NotBlank
    private String text;

    @NotNull
    private Instant timestamp;

    @NotNull
    private Boolean sent;

    @NotBlank
    private String senderParticipantId;

    @NotNull
    @NotEmpty
    private List<String> contextsId;

    public Message(@NotBlank String text, @NotNull Instant timestamp, @NotNull Boolean sent, @NotBlank String senderParticipantId, @NotNull @NotEmpty List<String> contextsId) {
        this.text = text;
        this.timestamp = timestamp;
        this.sent = sent;
        this.senderParticipantId = senderParticipantId;
        this.contextsId = contextsId;
    }
}
