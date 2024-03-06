package com.Final.Back.Repository;

import com.Final.Back.Modles.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepo extends JpaRepository<Agent,Long> {
    @Override
    Agent save(Agent agent);
}
