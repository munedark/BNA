package com.Final.Back.Repository.CompteBancaire;

import com.Final.Back.Modles.CompteBancaire.CompteBancaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteBancaireRepo extends JpaRepository<CompteBancaire,Long> {
}
