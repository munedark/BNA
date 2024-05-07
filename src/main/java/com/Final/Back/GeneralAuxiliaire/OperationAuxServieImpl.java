package com.Final.Back.GeneralAuxiliaire;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationAuxServieImpl implements OperationAuxService {
    @Autowired
    private OperationAuxRepo operationAuxRepo;


    public OperationAux saveOperationAux(OperationAux OperationAux) {
        return operationAuxRepo.save(OperationAux);
    }


    public OperationAux getOperationAuxById(Long id) {
        return operationAuxRepo.findById(id).orElse(null);
    }


    public OperationAux updateOperationAux(Long id, OperationAux updatedOperationAux) {
        OperationAux existingOperationAux = operationAuxRepo.findById(id).orElse(null);
        if (existingOperationAux != null) {
            existingOperationAux.setTypeAuxiliaire(updatedOperationAux.getTypeAuxiliaire());
            existingOperationAux.setAuxiliaire(updatedOperationAux.getAuxiliaire());
            existingOperationAux.setCinAuxiliaire(updatedOperationAux.getCinAuxiliaire());
            existingOperationAux.setNomAuxiliaire(updatedOperationAux.getNomAuxiliaire());
            existingOperationAux.setMntHonoraire(updatedOperationAux.getMntHonoraire());
            existingOperationAux.setNatureAuxiliaire(updatedOperationAux.getNatureAuxiliaire());
            existingOperationAux.setRneAuxiliaire(updatedOperationAux.getRneAuxiliaire());
            existingOperationAux.setPrenomAuxiliaire(updatedOperationAux.getPrenomAuxiliaire());
            existingOperationAux.setNumAffaireCTX(updatedOperationAux.getNumAffaireCTX());
            return operationAuxRepo.save(existingOperationAux);
        }
        return null;
    }


    public void deleteOperationAux(Long id) {
        operationAuxRepo.deleteById(id);
    }
}
