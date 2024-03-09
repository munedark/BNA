package com.Final.Back.Repository;

import com.Final.Back.Modles.AgentBna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepo extends JpaRepository<AgentBna,Long> {
    @Override
    AgentBna save(AgentBna agentBna);

}
