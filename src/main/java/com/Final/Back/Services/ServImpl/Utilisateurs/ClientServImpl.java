package com.Final.Back.Services.ServImpl.Utilisateurs;

import com.Final.Back.Modles.Utilisateurs.Client;
import com.Final.Back.Modles.Utilisateurs.Personne;
import com.Final.Back.Modles.Authentification.Profile;
import com.Final.Back.Repository.Utilisateurs.ClientRepo;
import com.Final.Back.Repository.Authentification.ProfileRepo;
import com.Final.Back.Services.UtilisateursServ.ClientServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServImpl implements ClientServ {

    @Autowired
    private ProfileRepo profileRepo;

    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public Client addClient(Client client, Profile profile) {
        Client user = new Client();
        user.setNom(client.getNom());
        user.setPrenom(client.getPrenom());
        user.setEmail(client.getEmail());
        user.setNumtele(client.getNumtele());

        Profile account = new Profile();
        account.setUsername(profile.getUsername());
        account.setPassword(passwordEncoder.encode(profile.getPassword()));
        account.setIsEnabled(true);
        account.setPersonne(user);
        account.setRole(profile.getRole());

        profileRepo.save(account);

        return clientRepo.save(user);
    }

    @Transactional
    public void deleteClient(String username) {
        Profile profile = profileRepo.findByUsername(username).orElse(null);
        if (profile != null) {
            Personne user = profile.getPersonne();
            if (user instanceof Client) {
                Client client = (Client) user;
                clientRepo.delete(client);
            }
            profileRepo.delete(profile);
        }
    }

    @Transactional
    public void modifyClient(String username, Client client, Profile profile) {
        Profile profileToUpdate = profileRepo.findByUsername(username).orElse(null);
        if (profileToUpdate != null) {
            Personne user = profileToUpdate.getPersonne();
            if (user instanceof Client) {
                Client clientToUpdate = (Client) user;
                clientToUpdate.setNom(client.getNom());
                clientToUpdate.setPrenom(client.getPrenom());
                clientToUpdate.setEmail(client.getEmail());
                clientToUpdate.setNumtele(client.getNumtele());
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
    public Client showClientByUsername(String username) {
        Profile profile = profileRepo.findByUsername(username).orElse(null);
        if (profile != null) {
            Personne user = profile.getPersonne();
            if (user instanceof Client) {
                return (Client) user;
            }
        }
        return null;
    }

    @Transactional
    public List<Client> showAllClients() {
        return clientRepo.findAll();
    }
}
