package com.criva.communicationservice.service;

import com.criva.communicationservice.model.dao.ContextDAO;
import com.criva.communicationservice.model.vo.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContextServiceImpl implements ContextService {

    private ContextDAO contextDAO;

    @Autowired
    public ContextServiceImpl(ContextDAO contextDAO) {

        this.contextDAO = contextDAO;
    }

    @Override
    public List<Context> saveContexts(List<Context> contexts) {

        return contextDAO.saveAll(contexts);
    }

    @Override
    public List<Context> findContextsByIds(List<String> ids) {

        return contextDAO.findAllByIdIn(ids);
    }
}