package com.Final.Back.Modles;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "CompteBancaire")
public class CompteBancaire {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    @Column(name="numCompte",nullable=false,unique=true)
    private Long numCompte ;
    @Column(name = "solde")
    private float solde;

    @OneToOne(mappedBy = "compteBancaire", cascade = CascadeType.ALL, optional = true)
    private DossierDebiteur dossierDebiteur;
    @ManyToOne
    @JoinColumn(name = "agence_bank_id", referencedColumnName = "id")
    private AgenceBank agenceBank;
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;
}
