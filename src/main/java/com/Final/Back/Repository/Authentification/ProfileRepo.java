package com.Final.Back.Repository.Authentification;

import com.Final.Back.Modles.Authentification.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProfileRepo extends JpaRepository<Profile, Long> {
    Profile save(Profile profile);
    Optional<Profile> findByUsername(String username);
    List<Profile> findByRole_RoleName(String roleName);
    List<Profile> findByRole_RoleNameIn(List<String> roleNames);
    void deleteByUsername(String username);
    @Transactional
    @Modifying
    @Query("UPDATE Profile p SET p.isEnabled = false WHERE p.username = :username")
    void disableProfileByUsername(String username);
}
