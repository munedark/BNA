package com.Final.Back.Repository.DossierDebiteur;

import com.Final.Back.Modles.DossierDebiteur.DossierDebiteur;
import com.Final.Back.Modles.DossierDebiteur.DossierId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DossierDebiteurRepo extends JpaRepository<DossierDebiteur, DossierId> {
    @Query("SELECT d FROM DossierDebiteur d WHERE d.dossierId.NumCtx = :numCtx")
    DossierDebiteur findByNumCtx(Long numCtx);
}
