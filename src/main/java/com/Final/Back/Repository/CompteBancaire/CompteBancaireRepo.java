package com.Final.Back.Repository.CompteBancaire;

import com.Final.Back.Modles.CompteBancaire.CompteBancaire;
import com.Final.Back.Modles.Utilisateurs.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompteBancaireRepo extends JpaRepository<CompteBancaire,Long> {
    List<CompteBancaire> findByClient(Client client);

}
