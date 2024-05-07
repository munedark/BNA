package com.Final.Back.Modles.CompteBancaire;

import com.Final.Back.Modles.CompteBancaire.CompteBancaire;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AgenceBank")
public class AgenceBank {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "agenceBank_id_Sequence")
    @SequenceGenerator(name = "agenceBank_id_Sequence", sequenceName = "AGENCE_BANK_ID_SEQ")
    private Long idAgence;
    @Column(unique = true)
    private String identifiantUnique;
    private String nomAgence;
    private String ville;

}