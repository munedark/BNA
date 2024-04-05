package com.Final.Back.Modles.CompteBancaire;

import com.Final.Back.Modles.Risques.Risque; // Assuming this import is needed
import com.Final.Back.Modles.Utilisateurs.Client;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "CompteBancaire")
public class CompteBancaire {
    @Id
    @Column(name = "numCompte", nullable = false, unique = true)
    private Long numCompte;

    @Column(name = "solde")
    private float solde;

    @ManyToOne
    @JoinColumn(name = "agence_bank_id", referencedColumnName = "idAgence" )
    private AgenceBank agenceBank;

    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;

}