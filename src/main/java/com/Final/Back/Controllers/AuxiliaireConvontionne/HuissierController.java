package com.Final.Back.Controllers.AuxiliaireConvontionne;

import com.Final.Back.Modles.AuxiliaireConvontionne.Huissier;
import com.Final.Back.Services.AuxiliaireConvontionneServ.HuissierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agent/huissier")
public class HuissierController {
    @Autowired
    HuissierService huissierService;
    @GetMapping("/all")
    public ResponseEntity<List<Huissier>> getAllHuissiers() {
        List<Huissier> huissiers = huissierService.getAllHuissier();
        return new ResponseEntity<>(huissiers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Huissier> getHuissierById(@PathVariable("id") Long id) {
        Optional<Huissier> huissier = huissierService.getHuissierById(id);
        return huissier.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Huissier> saveHuissier(@RequestBody Huissier huissier) {
        Huissier savedHuissier = huissierService.saveHuissier(huissier);
        return new ResponseEntity<>(savedHuissier, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHuissierById(@PathVariable("id") Long id) {
        huissierService.deleteHuissierById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
