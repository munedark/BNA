package com.Final.Back.Controllers;

import com.Final.Back.Dto.AuthADto;
import com.Final.Back.Dto.AuthCDto;
import com.Final.Back.Dto.AuthVDto;
import com.Final.Back.Modles.Agent;
import com.Final.Back.Modles.Authentification;
import com.Final.Back.Modles.Client;
import com.Final.Back.Modles.Validateur;
import com.Final.Back.Repository.AgentRepo;
import com.Final.Back.Repository.ClientRepo;
import com.Final.Back.Services.AgentServ;
import com.Final.Back.Services.ClientServ;
import com.Final.Back.Services.ValidateurServ;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AgentServ agentServ;
    @Autowired
    private ClientServ clientServ;
    @Autowired
    private ValidateurServ validateurServ;

    @PostMapping(value = "addValidateur")
    @ResponseBody
    public Validateur addUser(@RequestBody AuthVDto uad) {
        Validateur u = uad.getV();
        Authentification a = uad.getAuth();
        return (validateurServ.addValidateur(u, a));
    }

    @PostMapping(value = "addAgent")
    @ResponseBody
    public Agent addUser(@RequestBody AuthADto uad) {
        Agent u = uad.getA();
        Authentification a = uad.getAuth();
        return (agentServ.addAgent(u, a));
    }

    @PostMapping(value = "addClient")
    @ResponseBody
    public Client addUser(@RequestBody AuthCDto uad) {
        Client u = uad.getC();
        Authentification a = uad.getAuth();
        return (clientServ.addClient(u, a));
    }
}
