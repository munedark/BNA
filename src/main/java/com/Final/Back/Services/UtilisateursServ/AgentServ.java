package com.Final.Back.Services.UtilisateursServ;

import com.Final.Back.Modles.Utilisateurs.AgentBna;
import com.Final.Back.Modles.Authentification.Profile;

public interface AgentServ {
    AgentBna addAgent(AgentBna agentBna, Profile profile);

    void deleteAgent(String username);

    void modifyAgent(String username, AgentBna agentBna, Profile profile);

    AgentBna showAgentByUsername(String username);

    Iterable<AgentBna> showAllAgents();
}
