package com.Final.Back.Services.ServImpl.Journales;

import com.Final.Back.Modles.Journales.JournalDetail;
import com.Final.Back.Repository.Journales.JournalDetailRepo;
import com.Final.Back.Services.JournalesServ.JournalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalDetailServiceImpl implements JournalDetailService {

    private final JournalDetailRepo journalDetailRepo;

    @Autowired
    public JournalDetailServiceImpl(JournalDetailRepo journalDetailRepo) {
        this.journalDetailRepo = journalDetailRepo;
    }

    @Override
    public List<JournalDetail> getAllJournalDetails() {
        return journalDetailRepo.findAll();
    }

    @Override
    public Optional<JournalDetail> getJournalDetailById(Long id) {
        return journalDetailRepo.findById(id);
    }

    @Override
    public JournalDetail saveJournalDetail(JournalDetail journalDetail) {
        return journalDetailRepo.save(journalDetail);
    }

    @Override
    public void deleteJournalDetailById(Long id) {
        journalDetailRepo.deleteById(id);
    }
}
