package com.Final.Back.Dto;

import com.Final.Back.Modles.DossierDebiteur.DossierDebiteur;
import com.Final.Back.Modles.Risques.Risque;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@Data

public class ClientInfo {
    DossierDebiteur dossierDebiteur;
    List<Risque> risques;
}
