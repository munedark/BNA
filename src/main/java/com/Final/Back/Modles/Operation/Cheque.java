package com.Final.Back.Modles.Operation;

import com.Final.Back.Modles.CompteBancaire.AgenceBank;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
public class Cheque {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "cheque_id_Sequence")
    @SequenceGenerator(name = "cheque_id_Sequence", sequenceName = "CHEQUE_ID_SEQ")
    @Column(name="idCheque")
    private Long idCheque;
    @Column
    Long numCheque;
    @Column
    float mntCheque;
    @Column
    String ribDonneur;
    @ManyToOne
    @JoinColumn(name = "agence_bank_id", referencedColumnName = "idAgence" )
    AgenceBank agenceCheque;
    @Column
    String motif;

}
