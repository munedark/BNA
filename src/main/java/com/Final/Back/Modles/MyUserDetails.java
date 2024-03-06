package com.Final.Back.Modles;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {
    private String username;
    private String password;
    private boolean enabled;
    private List<GrantedAuthority> authorities;

    public MyUserDetails(Authentification user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.enabled = user.getIsEnabled();
        if (user.getIsAdmin()) {
            this.authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMINISTRATOR"));
        } else {
            this.authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getUser().getClass().getSimpleName().toUpperCase()));
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
