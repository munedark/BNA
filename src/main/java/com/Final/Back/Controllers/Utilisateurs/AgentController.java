package com.Final.Back.Controllers.Utilisateurs;

import com.Final.Back.Dto.AuthADto;
import com.Final.Back.Modles.Utilisateurs.AgentBna;
import com.Final.Back.Modles.Authentification.Profile;
import com.Final.Back.Services.UtilisateursServ.AgentServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AgentController {
    @Autowired
    private AgentServ agentServ;


    @PostMapping(value = "/addAgent")
    @ResponseBody
    public AgentBna addUser(@RequestBody AuthADto uad) {
        AgentBna u = uad.getAgent();
        Profile a = uad.getProfile();
        return (agentServ.addAgent(u,a));
    }




    @PutMapping("/modifyAgent/{username}")
    public void modifyAgent(@PathVariable String username, @RequestBody AuthADto authADto) {
        AgentBna agentBna = authADto.getAgent();
        Profile profile = authADto.getProfile();
        agentServ.modifyAgent(username, agentBna, profile);
    }

    @GetMapping("/showAgentByUsername/{username}")
    public AgentBna showAgentByUsername(@PathVariable String username) {
        return agentServ.showAgentByUsername(username);
    }

    @GetMapping("/showAllAgents")
    public Iterable<AgentBna> showAllAgents() {
        return agentServ.showAllAgents();
    }

    @DeleteMapping("/deleteAgent/{username}")
    public void deleteAgent(@PathVariable String username) {
        agentServ.deleteAgent(username);
    }


}
