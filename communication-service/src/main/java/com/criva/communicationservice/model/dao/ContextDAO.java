package com.criva.communicationservice.model.dao;

import com.criva.communicationservice.model.vo.Context;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ContextDAO extends MongoRepository<Context, String> {

    List<Context> findAllByIdIn(List<String> ids);
}
