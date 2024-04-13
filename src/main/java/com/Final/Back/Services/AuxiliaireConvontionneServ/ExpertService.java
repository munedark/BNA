package com.Final.Back.Services.AuxiliaireConvontionneServ;

import com.Final.Back.Modles.AuxiliaireConvontionne.Expert;

import java.util.List;
import java.util.Optional;

public interface ExpertService {
    List<Expert> getAllExpert();
    Optional<Expert> getExpertById(Long id);
    Expert saveExpert(Expert Expert);
    void deleteExpertById(Long id);
}
