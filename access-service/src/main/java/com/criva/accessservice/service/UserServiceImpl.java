package com.criva.accessservice.service;

import com.criva.accessservice.handler.exception.UserNameAlreadyTakenException;
import com.criva.accessservice.handler.exception.UserNotFoundException;
import com.criva.accessservice.model.dao.UserDAO;
import com.criva.accessservice.model.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {

        this.userDAO = userDAO;
    }

    @Override
    public User findUserById(String id) {

        return userDAO.findById(id).orElseThrow(
                () -> new UserNotFoundException(UserNotFoundException.USER_NOT_FOUND)
        );
    }

    @Override
    public User saveUser(User user) {

        User savedUser = findUserByName(user.getName());

        if(savedUser != null) {

            throw new UserNameAlreadyTakenException(UserNameAlreadyTakenException.USER_NAME_ALREADY_TAKEN);
        }

        return userDAO.save(user);
    }

    @Override
    public User updateUser(User user) {

        User savedUser = findUserByName(user.getName());

        if(savedUser != null && !savedUser.getId().equals(user.getId())) {

            throw new UserNameAlreadyTakenException(UserNameAlreadyTakenException.USER_NAME_ALREADY_TAKEN);
        }

        return userDAO.save(user);
    }

    @Override
    public void deleteUser(User user) {

        userDAO.delete(user);
    }

    @Override
    public List<User> findAllUsers() {

        return userDAO.findAll();
    }

    @Override
    public User findUserByName(String name) {

        return userDAO.findByName(name);
    }

    @Override
    public List<User> findUsersById(List<String> ids) {

        return userDAO.findByIdIn(ids);
    }

    @Override
    public Boolean isAllUsersValid(List<String> ids) {

        List<User> users = findUsersById(ids);

        return (users.size() == ids.size());
    }
}