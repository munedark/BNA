package com.Final.Back.Controllers.Utilisateurs;

import com.Final.Back.Dto.AuthCDto;
import com.Final.Back.Modles.Utilisateurs.Client;
import com.Final.Back.Modles.Authentification.Profile;
import com.Final.Back.Services.UtilisateursServ.ClientServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class ClientController {
    @Autowired
    private ClientServ clientServ;
    @PostMapping(value = "/addClient")
    @ResponseBody
    public Client addClient(@RequestBody AuthCDto uad) {
        Client client = uad.getClient();
        Profile profile = uad.getProfile();
        return clientServ.addClient(client, profile);
    }

    // Modify an existing client
    @PutMapping("/modifyClient/{username}")
    public void modifyClient(@PathVariable String username, @RequestBody AuthCDto authCDto) {
        Client client = authCDto.getClient();
        Profile profile = authCDto.getProfile();
        clientServ.modifyClient(username, client, profile);
    }

    // Retrieve a client by username
    @GetMapping("/showClientByUsername/{username}")
    public Client showClientByUsername(@PathVariable String username) {
        return clientServ.showClientByUsername(username);
    }

    // Retrieve all clients
    @GetMapping("/showAllClients")
    public List<Client> showAllClients() {
        return clientServ.showAllClients();
    }

    // Delete a client
    @DeleteMapping("/deleteClient/{username}")
    public void deleteClient(@PathVariable String username) {
        clientServ.deleteClient(username);
    }

}
