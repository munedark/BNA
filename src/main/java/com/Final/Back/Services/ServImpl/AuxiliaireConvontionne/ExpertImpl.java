package com.Final.Back.Services.ServImpl.AuxiliaireConvontionne;


import com.Final.Back.Modles.AuxiliaireConvontionne.Expert;
import com.Final.Back.Repository.AuxiliaireConvontionne.ExpertRepo;
import com.Final.Back.Services.AuxiliaireConvontionneServ.ExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ExpertImpl implements ExpertService {
    @Autowired
    ExpertRepo expertRepo;

    @Override
    public List<Expert> getAllExpert() {
        return expertRepo.findAll();
    }

    @Override
    public Optional<Expert> getExpertById(Long id) {
        return expertRepo.findById(id);
    }

    @Override
    public Expert saveExpert(Expert expert) {
        return expertRepo.save(expert);
    }

    @Override
    public void deleteExpertById(Long id) {
        expertRepo.deleteById(id);
    }
}
