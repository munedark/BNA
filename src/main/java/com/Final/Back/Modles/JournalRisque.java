package com.Final.Back.Modles;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "JournalRisque")
public class JournalRisque {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "journalRisque_id_Sequence")
    @SequenceGenerator(name ="journalRisque_id_Sequence", sequenceName = "journalRisque_ID_SEQ")
    @Column(name="idJournalRisque",nullable=false,unique=true)
    private Long idJournalRisque;
    @OneToMany(mappedBy = "journalRisque")
    private List<Risque> historique;
}
