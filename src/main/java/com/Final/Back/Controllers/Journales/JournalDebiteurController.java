package com.Final.Back.Controllers.Journales;

import com.Final.Back.Modles.Journales.JournalDebiteur;
import com.Final.Back.Services.JournalesServ.JournalDebiteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/journal-debiteur")
public class JournalDebiteurController {

    private final JournalDebiteurService journalDebiteurService;

    @Autowired
    public JournalDebiteurController(JournalDebiteurService journalDebiteurService) {
        this.journalDebiteurService = journalDebiteurService;
    }

    @GetMapping("/all")
    public List<JournalDebiteur> getAllJournalDebiteurs() {
        return journalDebiteurService.getAllJournalDebiteurs();
    }

    @GetMapping("/{id}")
    public Optional<JournalDebiteur> getJournalDebiteurById(@PathVariable Long id) {
        return journalDebiteurService.getJournalDebiteurById(id);
    }

    @PostMapping("/add")
    public JournalDebiteur saveJournalDebiteur(@RequestBody JournalDebiteur journalDebiteur) {
        return journalDebiteurService.saveJournalDebiteur(journalDebiteur);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteJournalDebiteurById(@PathVariable Long id) {
        journalDebiteurService.deleteJournalDebiteurById(id);
    }
}
