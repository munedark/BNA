package com.Final.Back.Services.ServImpl.SelectOptions;

import com.Final.Back.Modles.SelectOptions.DiversTypePiece;
import com.Final.Back.Repository.SelectOptions.DiversTypePieceRepo;
import com.Final.Back.Services.SelectOptionsServ.DiversTypePieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiversTypePieceImpl implements DiversTypePieceService {

    private final DiversTypePieceRepo diversTypePieceRepo;

    @Autowired
    public DiversTypePieceImpl(DiversTypePieceRepo diversTypePieceRepo) {
        this.diversTypePieceRepo = diversTypePieceRepo;
    }

    @Override
    public List<DiversTypePiece> getAllPieces() {
        return diversTypePieceRepo.findAll();
    }

    @Override
    public Optional<DiversTypePiece> getPieceById(Long id) {
        return diversTypePieceRepo.findById(id);
    }

    @Override
    public DiversTypePiece savePiece(DiversTypePiece piece) {
        return diversTypePieceRepo.save(piece);
    }

    @Override
    public void deletePieceById(Long id) {
        diversTypePieceRepo.deleteById(id);
    }
}
