package com.Final.Back.Modles;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "CompteBancaire")
public class CompteBancaire {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "compte_id_Sequence")
    @SequenceGenerator(name = "compte_id_Sequence", sequenceName = "COMPTE_ID_SEQ")
    @Column(name="numCompte",nullable=false,unique=true)
    private Long numCompte ;

    @Column(name = "solde")
    private float solde;

    @ManyToOne
    @JoinColumn(name = "agence_bank_id", referencedColumnName = "idAgence")
    private AgenceBank agenceBank;
    @ManyToOne
    @JoinColumn(name = "id")
    private Client client;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Risque> risque;
}
