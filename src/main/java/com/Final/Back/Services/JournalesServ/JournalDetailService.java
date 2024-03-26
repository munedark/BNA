package com.Final.Back.Services.JournalesServ;

import com.Final.Back.Modles.Journales.JournalDetail;

import java.util.List;
import java.util.Optional;

public interface JournalDetailService {
    List<JournalDetail> getAllJournalDetails();
    Optional<JournalDetail> getJournalDetailById(Long id);
    JournalDetail saveJournalDetail(JournalDetail journalDetail);
    void deleteJournalDetailById(Long id);
}
