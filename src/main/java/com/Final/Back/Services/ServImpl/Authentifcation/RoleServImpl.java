package com.Final.Back.Services.ServImpl.Authentifcation;

import com.Final.Back.Modles.Authentification.Role;
import com.Final.Back.Repository.Authentification.RoleRepo;
import com.Final.Back.Services.AuthentificationServ.RoleServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RoleServImpl implements RoleServ {
    @Autowired
    RoleRepo roleRepo;
    @Transactional
    @Override
    public Role addRole(Role role) {
        return roleRepo.save(role);
    }
}
