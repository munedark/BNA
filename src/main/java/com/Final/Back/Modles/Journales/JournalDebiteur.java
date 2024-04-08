package com.Final.Back.Modles.Journales;

import com.Final.Back.Modles.DossierDebiteur.DossierDebiteur;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "JournalDebiteur")
public class JournalDebiteur {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "journalDebiteur_id_Sequence")
    @SequenceGenerator(name ="journalDebiteur_id_Sequence", sequenceName = "journalDebiteur_ID_SEQ")
    @Column(name="idJournalDebiteur",nullable=false,unique=true)
    private Long idJournalDebiteur;

}
