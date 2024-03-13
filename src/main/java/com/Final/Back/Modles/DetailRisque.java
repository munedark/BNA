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
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    @Column(name="idDetailRisque",nullable=false,unique=true)
    private  Long idDetailRisque;
    @Column(name = "dateEchance")
    private Date dateEchance;
    @Column(name = "mntEchance")
    private Float mntEchance;
}
