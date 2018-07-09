package com.criva.accessservice.controller;

import com.criva.accessservice.model.vo.User;
import com.criva.accessservice.service.UserService;
import com.criva.accessservice.validator.group.AfterSaving;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping(value = "/users",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User findUserById(@NotBlank @PathVariable("id") String id) {

        return userService.findUserById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public User saveUser(@Valid @RequestBody User user) {

        return userService.saveUser(user);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@Validated({AfterSaving.class}) @RequestBody User user) {

        return userService.updateUser(user);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@Validated({AfterSaving.class}) @RequestBody User user) {

        userService.deleteUser(user);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAllUsers() {

        return userService.findAllUsers();
    }

    @GetMapping(params = "name")
    @ResponseStatus(HttpStatus.OK)
    public User findUserByName(@NotBlank @RequestParam("name") String name) {

        return userService.findUserByName(name);
    }

    @GetMapping(params = "ids")
    @ResponseStatus(HttpStatus.OK)
    public Boolean isAllUsersValid(@NotEmpty @RequestParam("ids") List<String> ids) {

        return userService.isAllUsersValid(ids);
    }
}
