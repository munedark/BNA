package com.Final.Back.Modles.Operation;

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
    @Column(name="idCheque",nullable=false,unique=true)
    private Long idCheque;
    @Column
    long numCheque;
    @Column
    float mntCheque;
    @Column
    String ribDonneur;
    @Column
    String agenceCheque;
    @Column
    String motif;

}
