package com.criva.communicationservice.handler;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class RequestError {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timestamp;

    private Integer status;

    private String message;

    public RequestError() {

        timestamp = LocalDateTime.now();
    }

    public RequestError(Integer status, String message) {

        this();
        this.status = status;
        this.message = message;
    }
}
