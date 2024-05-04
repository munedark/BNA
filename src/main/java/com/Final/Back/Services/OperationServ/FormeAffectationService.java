package com.Final.Back.Services.OperationServ;

import com.Final.Back.Modles.Operation.FormeAffectation;

import java.util.List;

public interface FormeAffectationService {
    List<FormeAffectation> getAllFormeAffectations();
    FormeAffectation getFormeAffectationById(Long id);
    FormeAffectation createFormeAffectation(FormeAffectation formeAffectation);
    FormeAffectation updateFormeAffectation(Long id, FormeAffectation formeAffectation);
    void deleteFormeAffectation(Long id);
}
