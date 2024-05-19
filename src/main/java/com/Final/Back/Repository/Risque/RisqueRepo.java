package com.Final.Back.Repository.Risque;

import com.Final.Back.Modles.Risques.Risque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RisqueRepo extends JpaRepository<Risque,Long> {
    List<Risque> findBySoldePrincipaleRisqueAndIrAndIc(float soldePrincipaleRisque, float ir, float ic);
}
