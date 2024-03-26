package com.Final.Back.Repository.Authentification;

import com.Final.Back.Modles.Authentification.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    Role save(Role role);
}

