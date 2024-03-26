package com.Final.Back.Services.ServImpl.Journales;

import com.Final.Back.Modles.Journales.JournalRisque;
import com.Final.Back.Repository.Journales.JournalRisqueRepo;
import com.Final.Back.Services.JournalesServ.JournalRisqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalRisqueServiceImpl implements JournalRisqueService {

    private final JournalRisqueRepo journalRisqueRepo;

    @Autowired
    public JournalRisqueServiceImpl(JournalRisqueRepo journalRisqueRepo) {
        this.journalRisqueRepo = journalRisqueRepo;
    }

    @Override
    public List<JournalRisque> getAllJournalRisques() {
        return journalRisqueRepo.findAll();
    }

    @Override
    public Optional<JournalRisque> getJournalRisqueById(Long id) {
        return journalRisqueRepo.findById(id);
    }

    @Override
    public JournalRisque saveJournalRisque(JournalRisque journalRisque) {
        return journalRisqueRepo.save(journalRisque);
    }

    @Override
    public void deleteJournalRisqueById(Long id) {
        journalRisqueRepo.deleteById(id);
    }
}
