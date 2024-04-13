package com.Final.Back.Services.ServImpl.AuxiliaireConvontionne;

import com.Final.Back.Modles.AuxiliaireConvontionne.Avocat;

import com.Final.Back.Repository.AuxiliaireConvontionne.AvocatRepo;
import com.Final.Back.Services.AuxiliaireConvontionneServ.AvocatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AvocatImpl implements AvocatService {
    @Autowired
    AvocatRepo avocatRepo;

    @Override
    public List<Avocat> getAllAvocat() {
        return avocatRepo.findAll();
    }

    @Override
    public Optional<Avocat> getAvocatById(Long id) {
        return avocatRepo.findById(id);
    }

    @Override
    public Avocat saveAvocat(Avocat Avocat) {
        return avocatRepo.save(Avocat);
    }

    @Override
    public void deleteAvocatById(Long id) {
        avocatRepo.deleteById(id);
    }
}
