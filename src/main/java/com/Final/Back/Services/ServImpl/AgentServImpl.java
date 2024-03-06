package com.Final.Back.Services.ServImpl;

import com.Final.Back.Modles.Agent;
import com.Final.Back.Modles.Authentification;
import com.Final.Back.Repository.AgentRepo;
import com.Final.Back.Repository.AuthRepo;
import com.Final.Back.Services.AgentServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
public class AgentServImpl implements AgentServ {
    @Autowired
    AuthRepo authRepo;
    @Autowired
    AgentRepo agentRepo;
    @Transactional
    public Agent addAgent(Agent u , Authentification a) {
        Agent user = new Agent();
        user.setNom(u.getNom());
        user.setPrenom(u.getPrenom());
        user.setEmail(u.getEmail());
        user.setNumtele(u.getNumtele());
        user.setMatriculeAgent(u.getMatriculeAgent());

        Authentification account = new Authentification();
        account.setUsername(a.getUsername());
        account.setPassword(a.getPassword());
        account.setIsAdmin(false);
        account.setIsEnabled(true);
        account.setUser(user);


        authRepo.save(account);
        return agentRepo.save(user);
    }

}
