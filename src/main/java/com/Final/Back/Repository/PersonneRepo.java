package com.Final.Back.Repository;

import com.Final.Back.Modles.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneRepo extends JpaRepository<Personne,Long> {
    Personne save(Personne personne);

}
