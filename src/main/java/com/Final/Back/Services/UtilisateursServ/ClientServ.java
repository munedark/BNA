package com.Final.Back.Services.UtilisateursServ;

import com.Final.Back.Modles.Authentification.Profile;
import com.Final.Back.Modles.Utilisateurs.Client;

import java.util.List;

public interface ClientServ {
    Client addClient(Client u , Profile a);
    void deleteClient(String username);
    void modifyClient(String username, Client client, Profile profile);
    Client showClientByUsername(String username);
    List<Client> showAllClients();
}
