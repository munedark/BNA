package com.Final.Back.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DebiteurInfo {
    private float numCtx;
    private String nom;
    private String prenom;
    private boolean etat_CTX;
    private LocalDate dateTransfert;
    private float soldeRecouvrement;
}
