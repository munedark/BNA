package com.Final.Back.Services.ServImpl;

import com.Final.Back.Modles.Client;
import com.Final.Back.Modles.Profile;
import com.Final.Back.Repository.ClientRepo;
import com.Final.Back.Repository.ProfileRepo;
import com.Final.Back.Services.ClientServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientServImpl implements ClientServ {

    @Autowired
    private ProfileRepo profileRepo;

    @Autowired
    private ClientRepo clientRepo;

    @Transactional
    public Client addClient(Client client, Profile profile) {

        Client user = new Client();
        user.setNom(client.getNom());
        user.setPrenom(client.getPrenom());
        user.setEmail(client.getEmail());
        user.setNumtele(client.getNumtele());
        user.setMatriculeClient(client.getMatriculeClient());

        Profile account = new Profile();
        account.setUsername(profile.getUsername());
        account.setPassword(profile.getPassword());
        account.setIsEnabled(true);
        account.setUser(user);
        account.setRole(profile.getRole());

        profileRepo.save(account);

        return clientRepo.save(user);
    }
}
