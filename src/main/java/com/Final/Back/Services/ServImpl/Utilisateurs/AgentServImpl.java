package com.Final.Back.Services.ServImpl.Utilisateurs;

import com.Final.Back.Modles.Utilisateurs.AgentBna;
import com.Final.Back.Modles.Utilisateurs.Personne;
import com.Final.Back.Modles.Authentification.Profile;
import com.Final.Back.Repository.Utilisateurs.AgentRepo;
import com.Final.Back.Repository.Authentification.ProfileRepo;
import com.Final.Back.Services.UtilisateursServ.AgentServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
public class AgentServImpl implements AgentServ {
    @Autowired
    ProfileRepo profileRepo;
    @Autowired
    AgentRepo agentRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public AgentBna addAgent(AgentBna agentBna, Profile profile) {
        AgentBna user = new AgentBna();
        user.setNom(agentBna.getNom());
        user.setPrenom(agentBna.getPrenom());
        user.setEmail(agentBna.getEmail());
        user.setNumtele(agentBna.getNumtele());


        Profile account = new Profile();
        account.setUsername(profile.getUsername());
        account.setPassword(passwordEncoder.encode(profile.getPassword()));
        account.setIsEnabled(true);
        account.setPersonne(user);
        account.setRole(profile.getRole());


        profileRepo.save(account);
        return agentRepo.save(user);
    }

    @Transactional
    public void deleteAgent(String username) {
        Profile profile = profileRepo.findByUsername(username).orElse(null);
        if (profile != null) {
            Personne user = profile.getPersonne();
            if (user instanceof AgentBna) {
                AgentBna agent = (AgentBna) user;
                agentRepo.delete(agent);
            }
            profileRepo.delete(profile);
        }
    }

    @Transactional
    public void modifyAgent(String username, AgentBna agentBna, Profile profile) {
        Profile profileToUpdate = profileRepo.findByUsername(username).orElse(null);
        if (profileToUpdate != null) {
            Personne user = profileToUpdate.getPersonne();
            if (user instanceof AgentBna) {
                AgentBna agent = (AgentBna) user;
                agent.setNom(agentBna.getNom());
                agent.setPrenom(agentBna.getPrenom());
                agent.setEmail(agentBna.getEmail());
                agent.setNumtele(agentBna.getNumtele());

            }

            profileToUpdate.setUsername(profile.getUsername());
            profileToUpdate.setPassword(passwordEncoder.encode(profile.getPassword()));
            profileToUpdate.setIsEnabled(true);
            profileToUpdate.setPersonne(user);
            profileToUpdate.setRole(profile.getRole());
            profileRepo.save(profileToUpdate);
        }
    }

    @Transactional
    public AgentBna showAgentByUsername(String username) {
        Profile profile = profileRepo.findByUsername(username).orElse(null);
        if (profile != null) {
            Personne user = profile.getPersonne();
            if (user instanceof AgentBna) {
                return (AgentBna) user;
            }
        }
        return null;
    }


    @Transactional
    public Iterable<AgentBna> showAllAgents() {
        return agentRepo.findAll();
    }


}


