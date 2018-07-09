package com.criva.communicationservice.controller;

import com.criva.communicationservice.model.vo.Context;
import com.criva.communicationservice.service.ContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping(value = "/contexts",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class ContextController {

    private ContextService contextService;

    @Autowired
    public ContextController(ContextService contextService) {

        this.contextService = contextService;
    }

    @GetMapping(params = "ids")
    @ResponseStatus(HttpStatus.OK)
    public List<Context> findContextsByIds(@NotEmpty @RequestParam("ids") List<String> ids) {

        return contextService.findContextsByIds(ids);
    }
}
