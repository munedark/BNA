package com.Final.Back.Services.OperationServ;

import com.Final.Back.Modles.Operation.VirementTelecomponse;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface VirementTelecomponseService {
    List<VirementTelecomponse> getAllVirements();
    VirementTelecomponse getVirementById(Long id);
    List<VirementTelecomponse> getVirementsByDate(LocalDate date);
    VirementTelecomponse createVirement(VirementTelecomponse virement);
    void deleteVirement(Long id);
}