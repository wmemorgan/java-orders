package com.lambdaschool.salesapp.services;

import com.lambdaschool.salesapp.models.Agent;

public interface AgentService {

    Agent findByAgentId(long id);
}
