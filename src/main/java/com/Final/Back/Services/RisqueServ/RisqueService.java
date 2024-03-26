package com.Final.Back.Services.RisqueServ;

import com.Final.Back.Modles.Risques.Risque;

import java.util.List;
import java.util.Optional;

public interface RisqueService {
    List<Risque> getAllRisques();
    Optional<Risque> getRisqueById(Long id);
    Risque saveRisque(Risque risque);
    void deleteRisqueById(Long id);
}
