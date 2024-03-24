package com.Final.Back.Services.ServImpl;

import com.Final.Back.Modles.CompteBancaire;
import com.Final.Back.Repository.CompteBancaireRepo;
import com.Final.Back.Services.CompteBancaireServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompteBancaireImpl implements CompteBancaireServ {
    @Autowired
    CompteBancaireRepo compteBancaireRepo;

    @Override
    public CompteBancaire addCompteBancaire(CompteBancaire compteBancaire) {
        return compteBancaireRepo.save(compteBancaire);
    }
}
