package com.criva.communicationservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("access-service")
public interface AccessServiceClient {

    @GetMapping(value = "/users", params = "ids", consumes = MediaType.APPLICATION_JSON_VALUE)
    Boolean isAllUsersValid(@RequestParam("ids") List<String> ids);
}
