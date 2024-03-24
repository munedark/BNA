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
@Table(name = "JournalDetail")
public class JournalDetail {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "journalDetail_id_Sequence")
    @SequenceGenerator(name ="journalDetail_id_Sequence", sequenceName = "journalDetail_ID_SEQ")
    @Column(name="idJournalDetail",nullable=false,unique=true)
    private Long idJournalDetail;
    @OneToMany(mappedBy = "journalDetail")
    private List<DetailRisque> historique;
}
