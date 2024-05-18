package com.Final.Back.Operations.OperationFraisInitiesCtx;

import com.Final.Back.Operations.OperationCtx.OperationCtx;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class OperationFraisInitiesCTX extends OperationCtx {
    @Column(name ="MntFrais")
    private float mntFrais;
    @Column(name ="typeFrais")
    private String typeFrais;
    @Column(name ="typePiece")
    private String typePiece;
    @Column(name = "numeroPiece")
    private Long numeroPiece;
    @Column(name ="dateValeurCTX")
    private LocalDate dateValeurCTX;
    @Column(name ="matriculeEmploye")
    private String matriculeEmploye;

}
