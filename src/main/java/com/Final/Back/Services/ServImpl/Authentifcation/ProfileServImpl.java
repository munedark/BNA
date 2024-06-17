package com.Final.Back.Services.ServImpl.Authentifcation;

import com.Final.Back.Modles.Authentification.Profile;
import com.Final.Back.Repository.Authentification.ProfileRepo;
import com.Final.Back.Services.AuthentificationServ.ProfileServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileServImpl implements ProfileServ {
    @Autowired
    private ProfileRepo profileRepo;

    @Override
    public Profile saveProfile(Profile profile) {
        return profileRepo.save(profile);
    }

    @Override
    public Profile updateProfile(Profile profile) {
        return profileRepo.save(profile);
    }

    @Override
    public void deleteProfile(Long id) {
        profileRepo.deleteById(id);
    }

    @Override
    public Profile getProfileById(Long id) {
        return profileRepo.findById(id).orElse(null);
    }

    @Override
    public List<Profile> getAllProfiles() {
        return profileRepo.findAll();
    }

    @Override
    public Optional<Profile> findByUsername(String username) {
        return profileRepo.findByUsername(username);
    }

    @Override
    public List<Profile> findProfilesByClientRole() {
        return profileRepo.findByRole_RoleName("CLIENT");
    }

    @Override
    public List<Profile> findProfilesByValidatorOrManagerRole() {
        return profileRepo.findByRole_RoleNameIn(Arrays.asList("VALIDATEUR", "GESTIONNAIRE"));
    }

    @Override
    @Transactional
    public void supprimerParUsername(String username) {
        profileRepo.deleteByUsername(username);
    }

    @Override
    @Transactional
    public void disableProfile(String username) {
        profileRepo.disableProfileByUsername(username);
    }
}
