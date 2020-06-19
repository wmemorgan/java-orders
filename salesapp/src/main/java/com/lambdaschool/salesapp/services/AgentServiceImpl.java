package com.lambdaschool.salesapp.services;

import com.lambdaschool.salesapp.models.Agent;
import com.lambdaschool.salesapp.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service(value = "agentService")
public class AgentServiceImpl implements AgentService{

    @Autowired
    private AgentRepository agentRepository;

    @Override
    public Agent findByAgentId(long id) {

        return agentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agent " + id + " not found"));
    }
}
