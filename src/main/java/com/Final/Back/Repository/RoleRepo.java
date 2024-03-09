package com.Final.Back.Repository;

import com.Final.Back.Modles.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    Role save(Role role);
}

