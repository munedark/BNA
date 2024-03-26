package com.Final.Back.Services.JournalesServ;

import com.Final.Back.Modles.Journales.JournalRisque;

import java.util.List;
import java.util.Optional;

public interface JournalRisqueService {
    List<JournalRisque> getAllJournalRisques();
    Optional<JournalRisque> getJournalRisqueById(Long id);
    JournalRisque saveJournalRisque(JournalRisque journalRisque);
    void deleteJournalRisqueById(Long id);
}
