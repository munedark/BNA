package com.Final.Back.Services.JournalesServ;

import com.Final.Back.Modles.Journales.JournalDebiteur;

import java.util.List;
import java.util.Optional;

public interface JournalDebiteurService {
    List<JournalDebiteur> getAllJournalDebiteurs();
    Optional<JournalDebiteur> getJournalDebiteurById(Long id);
    JournalDebiteur saveJournalDebiteur(JournalDebiteur journalDebiteur);
    void deleteJournalDebiteurById(Long id);
}
