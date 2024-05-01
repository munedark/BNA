package com.Final.Back.Repository.Operation;

import com.Final.Back.Modles.Operation.VirementTelecomponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

import java.util.Date;
import java.util.List;

@Repository
public interface VirementTelecomponseRepo extends JpaRepository<VirementTelecomponse, Long> {
    List<VirementTelecomponse> findByDateOperation(LocalDate date);
}
