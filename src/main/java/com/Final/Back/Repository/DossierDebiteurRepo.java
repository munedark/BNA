package com.Final.Back.Repository;

import com.Final.Back.Modles.DossierDebiteur;
import com.Final.Back.Modles.DossierId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DossierDebiteurRepo extends JpaRepository<DossierDebiteur, DossierId> {
}
