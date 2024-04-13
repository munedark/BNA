package com.Final.Back.Services.AuxiliaireConvontionneServ;

import com.Final.Back.Modles.AuxiliaireConvontionne.Huissier;

import java.util.List;
import java.util.Optional;

public interface HuissierService {
    List<Huissier> getAllHuissier();
    Optional<Huissier> getHuissierById(Long id);
    Huissier saveHuissier(Huissier Huissier);
    void deleteHuissierById(Long id);
}
