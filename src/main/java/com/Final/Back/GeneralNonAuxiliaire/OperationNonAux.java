package com.Final.Back.GeneralNonAuxiliaire;

import com.Final.Back.OperationFraisGeneraux.OperationFraisGeneraux;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class OperationNonAux extends OperationFraisGeneraux {
    @Column(name ="typePiece")
    private String typePiece;
    @Column(name = "numeroPiece")
    private Long numeroPiece;

}
