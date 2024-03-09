package com.Final.Back.Services.ServImpl;

import com.Final.Back.Modles.AgentBna;
import com.Final.Back.Modles.Profile;
import com.Final.Back.Repository.AgentRepo;
import com.Final.Back.Repository.ProfileRepo;
import com.Final.Back.Services.AgentServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
public class AgentServImpl implements AgentServ {
    @Autowired
    ProfileRepo profileRepo;
    @Autowired
    AgentRepo agentRepo;
    @Transactional
    public AgentBna addAgent(AgentBna agentBna , Profile profile) {
        AgentBna user = new AgentBna();
        user.setNom(agentBna.getNom());
        user.setPrenom(agentBna.getPrenom());
        user.setEmail(agentBna.getEmail());
        user.setNumtele(agentBna.getNumtele());
        user.setMatricule(agentBna.getMatricule());

        Profile account = new Profile();
        account.setUsername(profile.getUsername());
        account.setPassword(profile.getPassword());
        account.setIsEnabled(true);
        account.setUser(user);
        account.setRole(profile.getRole());


        profileRepo.save(account);
        return agentRepo.save(user);
    }

}
