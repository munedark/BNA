package com.Final.Back.Services.ServImpl.Risque;

import com.Final.Back.Modles.Risques.DetailRisque;
import com.Final.Back.Repository.Risque.DetailRisqueRepo;
import com.Final.Back.Services.RisqueServ.DetailRisqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetailRisqueServiceImpl implements DetailRisqueService {

    private final DetailRisqueRepo detailRisqueRepo;

    @Autowired
    public DetailRisqueServiceImpl(DetailRisqueRepo detailRisqueRepo) {
        this.detailRisqueRepo = detailRisqueRepo;
    }

    @Override
    public List<DetailRisque> getAllDetailRisques() {
        return detailRisqueRepo.findAll();
    }

    @Override
    public Optional<DetailRisque> getDetailRisqueById(Long id) {
        return detailRisqueRepo.findById(id);
    }

    @Override
    public DetailRisque saveDetailRisque(DetailRisque detailRisque) {
        return detailRisqueRepo.save(detailRisque);
    }

    @Override
    public void deleteDetailRisqueById(Long id) {
        detailRisqueRepo.deleteById(id);
    }
}
