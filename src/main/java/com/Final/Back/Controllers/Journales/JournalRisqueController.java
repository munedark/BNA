package com.Final.Back.Controllers.Journales;

import com.Final.Back.Modles.Journales.JournalRisque;
import com.Final.Back.Services.JournalesServ.JournalRisqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/journal-risque")
public class JournalRisqueController {

    private final JournalRisqueService journalRisqueService;

    @Autowired
    public JournalRisqueController(JournalRisqueService journalRisqueService) {
        this.journalRisqueService = journalRisqueService;
    }

    @GetMapping("/all")
    public List<JournalRisque> getAllJournalRisques() {
        return journalRisqueService.getAllJournalRisques();
    }

    @GetMapping("/{id}")
    public Optional<JournalRisque> getJournalRisqueById(@PathVariable Long id) {
        return journalRisqueService.getJournalRisqueById(id);
    }

    @PostMapping("/add")
    public JournalRisque saveJournalRisque(@RequestBody JournalRisque journalRisque) {
        return journalRisqueService.saveJournalRisque(journalRisque);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteJournalRisqueById(@PathVariable Long id) {
        journalRisqueService.deleteJournalRisqueById(id);
    }
}
