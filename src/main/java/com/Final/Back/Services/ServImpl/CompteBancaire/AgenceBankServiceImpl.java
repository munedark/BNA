package com.Final.Back.Services.ServImpl.CompteBancaire;

import com.Final.Back.Modles.CompteBancaire.AgenceBank;
import com.Final.Back.Repository.CompteBancaire.AgenceBankRepo;
import com.Final.Back.Services.CompteBancaire.AgenceBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AgenceBankServiceImpl implements AgenceBankService {

    private final AgenceBankRepo agenceBankRepo;

    @Autowired
    public AgenceBankServiceImpl(AgenceBankRepo agenceBankRepo) {
        this.agenceBankRepo = agenceBankRepo;
    }

    @Override
    public List<AgenceBank> getAllAgenceBanks() {
        return agenceBankRepo.findAll();
    }

    @Override
    public Optional<AgenceBank> getAgenceBankById(Long id) {
        Optional<AgenceBank> agenceBank = agenceBankRepo.findById(id);
        agenceBank.ifPresentOrElse(
                bank -> System.out.println("Found AgenceBank: " + bank),
                () -> System.out.println("AgenceBank with ID " + id + " not found")
        );
        return agenceBank;
    }

    @Override
    public AgenceBank saveAgenceBank(AgenceBank agenceBank) {
        return agenceBankRepo.save(agenceBank);
    }

    @Override
    public void deleteAgenceBankById(Long id) {
        agenceBankRepo.deleteById(id);
    }
}
