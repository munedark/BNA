package com.Final.Back.Services.CompteBancaireServ;

import com.Final.Back.Modles.CompteBancaire.CompteBancaire;

import java.util.List;

public interface CompteBancaireServ {
    CompteBancaire addCompteBancaire(CompteBancaire compteBancaire);
    CompteBancaire getCompteBancaireById(Long id);
    List<CompteBancaire> getAllComptesBancaires();
    CompteBancaire updateCompteBancaire(CompteBancaire compteBancaire);
    void deleteCompteBancaire(Long id);
    void addCompteBancaireToAgenceBank(Long compteBancaireId, Long agenceBankId);
}

