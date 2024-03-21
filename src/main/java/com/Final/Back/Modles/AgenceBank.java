package com.Final.Back.Modles;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "AgenceBank")
public class AgenceBank {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    @Column(name="idAgence",nullable=false,unique=true)
    private Long idAgence;
    @Column(name = "emplacement")
    private String emplacement;
    @OneToMany(mappedBy = "agenceBank", cascade = CascadeType.ALL)
    private List<CompteBancaire> comptesBancaires;
    @ManyToOne
    @JoinColumn(name = "agence_bank_id", referencedColumnName = "id")
    private AgenceBank agenceBank;

}
