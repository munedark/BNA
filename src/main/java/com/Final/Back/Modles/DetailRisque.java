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
@Table(name = "detailRisque")
public class DetailRisque {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "detail_id_Sequence")
    @SequenceGenerator(name = "detail_id_Sequence", sequenceName = "DETAIL_ID_SEQ")
    @Column(name="idDetailRisque",nullable=false,unique=true)
    private  Long idDetailRisque;
    @Column(name = "dateEchance")
    private Date dateEchance;
    @Column(name = "mntEchance")
    private Float mntEchance;
    @OneToOne
    @JoinColumn(name = "Jounral")
    private JournalDetail journalDetail;
}
