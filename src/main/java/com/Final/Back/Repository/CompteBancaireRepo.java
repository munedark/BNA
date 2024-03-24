package com.Final.Back.Repository;

import com.Final.Back.Modles.CompteBancaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteBancaireRepo extends JpaRepository<CompteBancaire,Long> {
}
