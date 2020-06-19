package com.lambdaschool.salesapp.repositories;

import com.lambdaschool.salesapp.models.Agent;
import org.springframework.data.repository.CrudRepository;

public interface AgentRepository extends CrudRepository<Agent, Long> {
}
