package com.Final.Back.Services;

import com.Final.Back.Modles.AgentBna;
import com.Final.Back.Modles.Profile;

public interface AgentServ {
    AgentBna addAgent(AgentBna agentBna, Profile profile);

    void deleteAgent(String username);

    void modifyAgent(String username, AgentBna agentBna, Profile profile);

    AgentBna showAgentByUsername(String username);

    Iterable<AgentBna> showAllAgents();
}
