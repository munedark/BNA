package com.Final.Back.Services.ServImpl.Journales;

import com.Final.Back.Modles.Journales.JournalDebiteur;
import com.Final.Back.Repository.Journales.JournalDebiteurRepo;
import com.Final.Back.Services.JournalesServ.JournalDebiteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalDebiteurServiceImpl implements JournalDebiteurService {

    private final JournalDebiteurRepo journalDebiteurRepo;

    @Autowired
    public JournalDebiteurServiceImpl(JournalDebiteurRepo journalDebiteurRepo) {
        this.journalDebiteurRepo = journalDebiteurRepo;
    }

    @Override
    public List<JournalDebiteur> getAllJournalDebiteurs() {
        return journalDebiteurRepo.findAll();
    }

    @Override
    public Optional<JournalDebiteur> getJournalDebiteurById(Long id) {
        return journalDebiteurRepo.findById(id);
    }

    @Override
    public JournalDebiteur saveJournalDebiteur(JournalDebiteur journalDebiteur) {
        return journalDebiteurRepo.save(journalDebiteur);
    }

    @Override
    public void deleteJournalDebiteurById(Long id) {
        journalDebiteurRepo.deleteById(id);
    }
}
