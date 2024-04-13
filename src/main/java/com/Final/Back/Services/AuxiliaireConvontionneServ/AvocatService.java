package com.Final.Back.Services.AuxiliaireConvontionneServ;



import com.Final.Back.Modles.AuxiliaireConvontionne.Avocat;

import java.util.List;
import java.util.Optional;

public interface AvocatService {
    List<Avocat> getAllAvocat();
    Optional<Avocat> getAvocatById(Long id);
    Avocat saveAvocat(Avocat avocat);
    void deleteAvocatById(Long id);
}
