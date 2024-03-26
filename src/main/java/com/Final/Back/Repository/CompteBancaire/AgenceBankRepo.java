package com.Final.Back.Repository.CompteBancaire;

import com.Final.Back.Modles.CompteBancaire.AgenceBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenceBankRepo extends JpaRepository<AgenceBank,Long> {
}
