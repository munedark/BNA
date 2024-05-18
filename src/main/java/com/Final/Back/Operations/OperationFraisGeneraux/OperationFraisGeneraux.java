package com.Final.Back.Operations.OperationFraisGeneraux;

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
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class OperationFraisGeneraux extends OperationCtx {

    @Column(name ="MntFrais")
    private float mntFrais;
    @Column(name ="typeFrais")
    private String typeFrais;
    @Column(name ="RIB")
    private Long rib;
    @Column(name ="nomBeneficiaire")
    private String nomBeneficiaire;
    @Column(name ="dateValeurCTX")
    private LocalDate dateValeurCTX;

}
