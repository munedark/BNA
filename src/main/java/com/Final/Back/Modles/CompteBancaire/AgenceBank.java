package com.Final.Back.Modles.CompteBancaire;

import com.Final.Back.Modles.CompteBancaire.CompteBancaire;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "AgenceBank")
public class AgenceBank {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "agenceBank_id_Sequence")
    @SequenceGenerator(name = "agenceBank_id_Sequence", sequenceName = "AGENCE_BANK_ID_SEQ")
    @Column(name="idAgence",nullable=false,unique=true)
    private Long idAgence;
    @Column(name = "emplacement")
    private String emplacement;
    @OneToMany(mappedBy = "agenceBank", cascade = CascadeType.ALL)
    private List<CompteBancaire> comptesBancaires;

}
