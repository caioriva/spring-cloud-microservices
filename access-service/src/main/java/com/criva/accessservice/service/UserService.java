package com.criva.accessservice.service;

import com.criva.accessservice.model.vo.User;

import java.util.List;

public interface UserService {

    User findUserById(String id);

    User saveUser(User user);

    User updateUser(User user);

    void deleteUser(User user);

    List<User> findAllUsers();

    User findUserByName(String name);

    List<User> findUsersById(List<String> ids);

    Boolean isAllUsersValid(List<String> users);
}
