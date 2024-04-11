package com.Final.Back.Repository.SelectOptions;

import com.Final.Back.Modles.SelectOptions.DiversTypePiece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiversTypePieceRepo extends JpaRepository<DiversTypePiece,Long> {
}
