package com.Final.Back.Services.AuthentificationServ;

import com.Final.Back.Modles.Authentification.Profile;

import java.util.List;
import java.util.Optional;

public interface ProfileServ {
    Profile saveProfile(Profile profile);
    Profile updateProfile(Profile profile);
    void deleteProfile(Long id);
    Profile getProfileById(Long id);
    List<Profile> getAllProfiles();
    Optional<Profile> findByUsername(String username);
    List<Profile> findProfilesByClientRole();
    List<Profile> findProfilesByValidatorOrManagerRole();
    void supprimerParUsername(String username);
    void disableProfile(String username);
}
