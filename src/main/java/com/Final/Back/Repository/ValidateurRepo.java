package com.Final.Back.Repository;

import com.Final.Back.Modles.Validateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidateurRepo extends JpaRepository<Validateur,Long> {
    Validateur save(Validateur validateur);
}
