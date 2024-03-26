package com.Final.Back.Services.CompteBancaire.ServImpl;

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
        return agenceBankRepo.findById(id);
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
