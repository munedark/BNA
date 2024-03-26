package com.Final.Back.Services.ServImpl.Authentifcation;

import com.Final.Back.Modles.Authentification.Profile;
import com.Final.Back.Modles.Authentification.MyUserDetails;
import com.Final.Back.Repository.Authentification.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    ProfileRepo profileRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Profile> user= profileRepo.findByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

        return user.map(MyUserDetails::new).get();
    }
}
