package com.Final.Back.Controllers;

import com.Final.Back.Dto.ClientInfo;
import com.Final.Back.Services.ServImpl.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ControllerClient {
    @Autowired
    ServiceClient serviceClient;
    @GetMapping("/info/{matricule}")
    ClientInfo infoClient(@PathVariable String matricule){
        return this.serviceClient.recherecheDossier(matricule);
    }
}
