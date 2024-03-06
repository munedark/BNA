package com.Final.Back.Services.ServImpl;

import com.Final.Back.Modles.Authentification;
import com.Final.Back.Modles.Client;
import com.Final.Back.Repository.AuthRepo;
import com.Final.Back.Repository.ClientRepo;
import com.Final.Back.Services.ClientServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
public class ClientServImpl implements ClientServ {
    @Autowired
    AuthRepo authRepo;
    @Autowired
    ClientRepo clientRepo;
    @Transactional
    public com.Final.Back.Modles.Client addClient(com.Final.Back.Modles.Client u , Authentification a) {
        com.Final.Back.Modles.Client user = new Client();
        user.setNom(u.getNom());
        user.setPrenom(u.getPrenom());
        user.setEmail(u.getEmail());
        user.setNumtele(u.getNumtele());
        user.setMatriculeClient(u.getMatriculeClient());

        Authentification account = new Authentification();
        account.setUsername(a.getUsername());
        account.setPassword(a.getPassword());
        account.setIsAdmin(false);
        account.setIsEnabled(true);
        account.setUser(user);


        authRepo.save(account);
        return clientRepo.save(user);
    }
}
