package com.Final.Back.Services.RisqueServ;

import com.Final.Back.Modles.Risques.DetailRisque;

import java.util.List;
import java.util.Optional;

public interface DetailRisqueService {
    List<DetailRisque> getAllDetailRisques();
    Optional<DetailRisque> getDetailRisqueById(Long id);
    DetailRisque saveDetailRisque(DetailRisque detailRisque);
    void deleteDetailRisqueById(Long id);
}
