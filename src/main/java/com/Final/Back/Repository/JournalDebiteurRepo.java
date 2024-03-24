package com.Final.Back.Repository;

import com.Final.Back.Modles.JournalDebiteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalDebiteurRepo extends JpaRepository<JournalDebiteur,Long> {
}
