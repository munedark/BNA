package com.Final.Back.Repository;

import com.Final.Back.Modles.Authentification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepo extends JpaRepository<Authentification,Long> {
    Authentification save(Authentification authentification);
    Optional<Authentification> findByUsername(String username);
}
