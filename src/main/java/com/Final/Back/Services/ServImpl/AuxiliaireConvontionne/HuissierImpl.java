package com.Final.Back.Services.ServImpl.AuxiliaireConvontionne;

import com.Final.Back.Modles.AuxiliaireConvontionne.Huissier;

import com.Final.Back.Repository.AuxiliaireConvontionne.HuissierRepo;
import com.Final.Back.Services.AuxiliaireConvontionneServ.HuissierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class HuissierImpl implements HuissierService {
    @Autowired
    HuissierRepo huissierRepo;

    @Override
    public List<Huissier> getAllHuissier() {
        return huissierRepo.findAll();
    }

    @Override
    public Optional<Huissier> getHuissierById(Long id) {
        return huissierRepo.findById(id);
    }

    @Override
    public Huissier saveHuissier(Huissier huissier) {
        return huissierRepo.save(huissier);
    }

    @Override
    public void deleteHuissierById(Long id) {
        huissierRepo.deleteById(id);
    }
}
