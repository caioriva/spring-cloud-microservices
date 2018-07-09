package com.criva.accessservice.model.dao;

import com.criva.accessservice.model.vo.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserDAO extends MongoRepository<User, String> {

    User findByName(String name);

    List<User> findByIdIn(List<String> ids);
}
