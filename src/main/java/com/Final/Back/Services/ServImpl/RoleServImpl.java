package com.Final.Back.Services.ServImpl;

import com.Final.Back.Modles.Role;
import com.Final.Back.Repository.RoleRepo;
import com.Final.Back.Services.RoleServ;
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
