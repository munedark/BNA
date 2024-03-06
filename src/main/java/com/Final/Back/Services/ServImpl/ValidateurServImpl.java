package com.Final.Back.Services.ServImpl;

import com.Final.Back.Modles.Authentification;
import com.Final.Back.Modles.Validateur;
import com.Final.Back.Repository.AuthRepo;
import com.Final.Back.Repository.ValidateurRepo;
import com.Final.Back.Services.ValidateurServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
public class ValidateurServImpl implements ValidateurServ {
    @Autowired
    AuthRepo authRepo;
    @Autowired
    ValidateurRepo validateurRepo;
    @Transactional
    public Validateur addValidateur(Validateur u , Authentification a) {
        Validateur user = new Validateur();
        user.setNom(u.getNom());
        user.setPrenom(u.getPrenom());
        user.setEmail(u.getEmail());
        user.setNumtele(u.getNumtele());
        user.setMatriculeValidateur(u.getMatriculeValidateur());

        Authentification account = new Authentification();
        account.setUsername(a.getUsername());
        account.setPassword(a.getPassword());
        account.setIsAdmin(false);
        account.setIsEnabled(true);
        account.setUser(user);


        authRepo.save(account);
        return validateurRepo.save(user);
    }
}
