package com.Final.Back.Controllers.AuxiliaireConvontionne;

import com.Final.Back.Modles.AuxiliaireConvontionne.Avocat;
import com.Final.Back.Services.AuxiliaireConvontionneServ.AvocatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agent/avocat")
public class AvocatController {
    String model;
    @Autowired
    AvocatService avocatService;
    @GetMapping("/all")
    public ResponseEntity<List<Avocat>> getAllAvocats() {
        List<Avocat> avocats = avocatService.getAllAvocat();
        return new ResponseEntity<>(avocats, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Avocat> getAvocatById(@PathVariable("id") Long id) {
        Optional<Avocat> avocat = avocatService.getAvocatById(id);
        return avocat.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Avocat> saveAvocat(@RequestBody Avocat avocat) {
        Avocat savedAvocat = avocatService.saveAvocat(avocat);
        return new ResponseEntity<>(savedAvocat, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAvocatById(@PathVariable("id") Long id) {
        avocatService.deleteAvocatById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
