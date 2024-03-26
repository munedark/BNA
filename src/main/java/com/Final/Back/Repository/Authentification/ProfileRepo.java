package com.Final.Back.Repository.Authentification;

import com.Final.Back.Modles.Authentification.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepo extends JpaRepository<Profile,Long> {
    Profile save(Profile profile);
    Optional<Profile> findByUsername(String username);
}
