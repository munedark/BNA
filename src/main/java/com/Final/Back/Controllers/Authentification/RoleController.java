package com.Final.Back.Controllers.Authentification;

import com.Final.Back.Modles.Authentification.Role;
import com.Final.Back.Services.AuthentificationServ.RoleServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class RoleController {
    @Autowired
    private RoleServ roleServ;
    @PostMapping("/addRole")
    public Role addRole(@RequestBody Role role) {
        return roleServ.addRole(role);
    }
}
