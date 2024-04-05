package com.Final.Back.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
public class CompteAgenceDTO {
    private Long compteBancaireId;
    private Long agenceBankId;
}
