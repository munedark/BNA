package com.Final.Back.Services.CompteBancaire;

import com.Final.Back.Modles.CompteBancaire.AgenceBank;

import java.util.List;
import java.util.Optional;

public interface AgenceBankService {
    List<AgenceBank> getAllAgenceBanks();
    Optional<AgenceBank> getAgenceBankById(Long id);
    AgenceBank saveAgenceBank(AgenceBank agenceBank);
    void deleteAgenceBankById(Long id);
}
