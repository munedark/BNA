package com.Final.Back.Controllers.SelectOption;
import com.Final.Back.Modles.SelectOptions.DiversTypePiece;
import com.Final.Back.Services.SelectOptionsServ.DiversTypePieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agent")
public class DiversTypePieceController {
    @Autowired
    DiversTypePieceService diversTypePieceService;


        @GetMapping("/divers/pieces")
        public ResponseEntity<List<DiversTypePiece>> getAllPieces() {
            List<DiversTypePiece> pieces = diversTypePieceService.getAllPieces();
            return new ResponseEntity<>(pieces, HttpStatus.OK);
        }

        @GetMapping("/divers/findPiece/{id}")
        public ResponseEntity<DiversTypePiece> getPieceById(@PathVariable("id") Long id) {
            Optional<DiversTypePiece> piece = diversTypePieceService.getPieceById(id);
            return piece.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }

        @PostMapping("/divers/addPiece")
        public ResponseEntity<DiversTypePiece> createPiece(@RequestBody DiversTypePiece piece) {
            DiversTypePiece createdPiece = diversTypePieceService.savePiece(piece);
            return new ResponseEntity<>(createdPiece, HttpStatus.CREATED);
        }

        @DeleteMapping("/divers/deletePieces/{id}")
        public ResponseEntity<Void> deletePiece(@PathVariable("id") Long id) {
            diversTypePieceService.deletePieceById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

