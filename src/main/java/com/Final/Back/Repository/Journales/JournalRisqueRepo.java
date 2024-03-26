package com.Final.Back.Repository.Journales;

import com.Final.Back.Modles.Journales.JournalRisque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRisqueRepo extends JpaRepository<JournalRisque,Long> {
}
