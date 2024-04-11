package com.Final.Back.Services.SelectOptionsServ;

import com.Final.Back.Modles.SelectOptions.DiversTypePiece;

import java.util.List;
import java.util.Optional;

public interface DiversTypePieceService {
    List<DiversTypePiece> getAllPieces();
    Optional<DiversTypePiece> getPieceById(Long id);
    DiversTypePiece savePiece(DiversTypePiece piece);
    void deletePieceById(Long id);
}
