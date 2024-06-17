package com.Final.Back.Inscription;

import com.Final.Back.Dto.AuthDto;
import com.Final.Back.Dto.VerifierDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inscription/")
public class InscriptionController {

    @Autowired
    private InscriptionService inscriptionService;

    @PostMapping("verifier-client")
    public boolean verficationClient(@RequestBody VerifierDto verifierDto) {
        return inscriptionService.verficationClient(verifierDto.getNumeroCompte(), verifierDto.getCin());
    }

    @PostMapping("verifier-identifiant")
    public boolean identifiantExistant(@RequestBody String identifiant) {
        return inscriptionService.identifiantExistant(identifiant);
    }

    @PostMapping("inscription")
    public void inscription(@RequestBody AuthDto authDto) {
        inscriptionService.inscription(authDto.getCin(), authDto.getPassword());
    }
}
