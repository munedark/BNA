package com.Final.Back.Controllers.CompteBancaire;

import com.Final.Back.Modles.CompteBancaire.AgenceBank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/agence")
public class AgenceController {

    @Autowired
    private com.Final.Back.Services.CompteBancaire.AgenceBankService agenceBankServiceServ;

    @GetMapping("/all")
    public List<AgenceBank> getAllAgenceBanks() {
        return agenceBankServiceServ.getAllAgenceBanks();
    }

    @GetMapping("/{id}")
    public Optional<AgenceBank> getAgenceBankById(@PathVariable Long id) {
        return agenceBankServiceServ.getAgenceBankById(id);
    }

    @PostMapping("/add")
    public AgenceBank saveAgenceBank(@RequestBody AgenceBank agenceBank) {
        return agenceBankServiceServ.saveAgenceBank(agenceBank);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAgenceBankById(@PathVariable Long id) {
        agenceBankServiceServ.deleteAgenceBankById(id);
    }
}
