package com.Final.Back.Modles.Journales;

import com.Final.Back.Modles.Risques.Risque;
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

}
