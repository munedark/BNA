package com.Final.Back.Repository;

import com.Final.Back.Modles.Utilisateur;
import jdk.jshell.execution.Util;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepo extends JpaRepository<Utilisateur,Long> {
    Utilisateur  save(Utilisateur utilisateur);

}
