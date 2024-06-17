package com.Final.Back.Inscription;

import com.Final.Back.Modles.Authentification.Profile;
import com.Final.Back.Modles.Authentification.Role;
import com.Final.Back.Modles.CompteBancaire.CompteBancaire;
import com.Final.Back.Repository.Authentification.ProfileRepo;
import com.Final.Back.Repository.CompteBancaire.CompteBancaireRepo;
import com.Final.Back.Repository.Utilisateurs.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class InscriptionServiImpl implements InscriptionService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ClientRepo clientRepo;
    @Autowired
    CompteBancaireRepo compteBancaireRepo;
    @Autowired
    ProfileRepo profileRepo;
    public boolean verficationClient(Long numeroCompte, Long cin){
        CompteBancaire compteBancaire=compteBancaireRepo.findById(numeroCompte).orElse(null);
        if(compteBancaire==null){
            return false;
        }
        else {
            if (compteBancaire.getClient().getCin().equals(cin)){
                return true;
            }
            else return false;
        }
    }

    public boolean identifiantExistant(String identifiant){
        Profile profile=profileRepo.findByUsername(identifiant).orElse(null);
        if(profile==null){
            return false;
        }
        else {
            return true;
        }
    }
    public void inscription(String Cin, String password){
        Profile profile=new Profile();
        Role role=new Role();
        role.setRoleName("CLIENT");
        role.setId((long)2);
        profile.setRole(role);
        profile.setUsername(Cin);
        profile.setIsEnabled(true);
        profile.setPersonne(clientRepo.findByCin(Long.parseLong(Cin)));
        profile.setPassword(passwordEncoder.encode(password));
        profileRepo.save(profile);
    }

}
