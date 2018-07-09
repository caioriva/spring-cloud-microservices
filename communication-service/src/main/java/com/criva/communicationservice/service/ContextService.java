package com.criva.communicationservice.service;

import com.criva.communicationservice.model.vo.Context;

import java.util.List;

public interface ContextService {

    List<Context> saveContexts(List<Context> contexts);

    List<Context> findContextsByIds(List<String> ids);
}