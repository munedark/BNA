package com.Final.Back.Repository.Operation;

import com.Final.Back.Modles.Operation.VirementTelecomponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VirementTelecomponseRepo extends JpaRepository<VirementTelecomponse,Long> {
}
