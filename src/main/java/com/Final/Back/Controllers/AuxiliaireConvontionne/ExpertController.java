package com.Final.Back.Controllers.AuxiliaireConvontionne;

import com.Final.Back.Modles.AuxiliaireConvontionne.Expert;
import com.Final.Back.Services.AuxiliaireConvontionneServ.ExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agent/expert")
public class ExpertController {
    @Autowired
    ExpertService expertService;
    @GetMapping("/all")
    public ResponseEntity<List<Expert>> getAllExperts() {
        List<Expert> experts = expertService.getAllExpert();
        return new ResponseEntity<>(experts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expert> getExpertById(@PathVariable("id") Long id) {
        Optional<Expert> expert = expertService.getExpertById(id);
        return expert.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Expert> saveExpert(@RequestBody Expert expert) {
        Expert savedExpert = expertService.saveExpert(expert);
        return new ResponseEntity<>(savedExpert, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpertById(@PathVariable("id") Long id) {
        expertService.deleteExpertById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
