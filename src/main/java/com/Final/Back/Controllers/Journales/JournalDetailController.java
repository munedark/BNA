package com.Final.Back.Controllers.Journales;

import com.Final.Back.Modles.Journales.JournalDetail;
import com.Final.Back.Services.JournalesServ.JournalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/journal-detail")
public class JournalDetailController {

    private final JournalDetailService journalDetailService;

    @Autowired
    public JournalDetailController(JournalDetailService journalDetailService) {
        this.journalDetailService = journalDetailService;
    }

    @GetMapping("/all")
    public List<JournalDetail> getAllJournalDetails() {
        return journalDetailService.getAllJournalDetails();
    }

    @GetMapping("/{id}")
    public Optional<JournalDetail> getJournalDetailById(@PathVariable Long id) {
        return journalDetailService.getJournalDetailById(id);
    }

    @PostMapping("/add")
    public JournalDetail saveJournalDetail(@RequestBody JournalDetail journalDetail) {
        return journalDetailService.saveJournalDetail(journalDetail);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteJournalDetailById(@PathVariable Long id) {
        journalDetailService.deleteJournalDetailById(id);
    }
}
