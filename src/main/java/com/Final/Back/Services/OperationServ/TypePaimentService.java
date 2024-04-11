package com.Final.Back.Services.OperationServ;

import com.Final.Back.Modles.Operation.TypeOperation;
import com.Final.Back.Modles.Operation.TypePaiment;

import java.util.List;
import java.util.Optional;

public interface TypePaimentService {
    List<TypePaiment> getAllTypePaiments();
    Optional<TypePaiment> getTypePaimentById(Long id);

    Optional<TypePaiment> getTypePaimentBylibelle(String libelle);
    TypePaiment saveTypePaiment(TypePaiment typePaiment);
    void deleteTypePaimentById(Long id);
}
