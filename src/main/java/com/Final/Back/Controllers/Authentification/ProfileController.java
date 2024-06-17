package com.Final.Back.Controllers.Authentification;

import com.Final.Back.Modles.Authentification.Profile;
import com.Final.Back.Services.AuthentificationServ.ProfileServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/Profile")
public class ProfileController {
    @Autowired
    private ProfileServ profileService;

    @PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) {
        return ResponseEntity.ok(profileService.saveProfile(profile));
    }

    @PutMapping
    public ResponseEntity<Profile> updateProfile(@RequestBody Profile profile) {
        return ResponseEntity.ok(profileService.updateProfile(profile));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
        profileService.deleteProfile(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Long id) {
        return ResponseEntity.ok(profileService.getProfileById(id));
    }

    @GetMapping
    public ResponseEntity<List<Profile>> getAllProfiles() {
        return ResponseEntity.ok(profileService.getAllProfiles());
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Optional<Profile>> getProfileByUsername(@PathVariable String username) {
        return ResponseEntity.ok(profileService.findByUsername(username));
    }

    @GetMapping("/role/client")
    public ResponseEntity<List<Profile>> getProfilesByClientRole() {
        return ResponseEntity.ok(profileService.findProfilesByClientRole());
    }

    @GetMapping("/role/validator-or-manager")
    public ResponseEntity<List<Profile>> getProfilesByValidatorOrManagerRole() {
        return ResponseEntity.ok(profileService.findProfilesByValidatorOrManagerRole());
    }

    @DeleteMapping("/delete/{username}")
    public void supprimerProfile(@PathVariable String username) {
        profileService.supprimerParUsername(username);
    }

    @PutMapping("/disable/{username}")
    public ResponseEntity<Void> disableProfile(@PathVariable String username) {
        profileService.disableProfile(username);
        return ResponseEntity.ok().build();
    }
}
