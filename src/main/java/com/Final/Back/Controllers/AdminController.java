package com.Final.Back.Controllers;

import com.Final.Back.Dto.AuthADto;
import com.Final.Back.Dto.AuthCDto;
import com.Final.Back.Modles.AgentBna;
import com.Final.Back.Modles.Profile;
import com.Final.Back.Modles.Client;
import com.Final.Back.Modles.Role;
import com.Final.Back.Services.AgentServ;
import com.Final.Back.Services.ClientServ;
import com.Final.Back.Services.RoleServ;
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
    private RoleServ roleServ;



    @PostMapping(value = "addAgent")
    @ResponseBody
    public AgentBna addUser(@RequestBody AuthADto uad) {
        AgentBna u = uad.getAgent();
        Profile a = uad.getProfile();
        return (agentServ.addAgent(u, a));
    }

    @PostMapping(value = "addClient")
    @ResponseBody
    public Client addUser(@RequestBody AuthCDto uad) {
        Client u = uad.getClient();
        Profile a = uad.getProfile();
        return (clientServ.addClient(u, a));
    }

    @PostMapping("/addRole")
    public Role addRole(@RequestBody Role role) {
        return roleServ.addRole(role);
    }
}
