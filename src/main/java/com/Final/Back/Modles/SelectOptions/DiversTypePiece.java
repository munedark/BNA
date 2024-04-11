package com.Final.Back.Modles.SelectOptions;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiversTypePiece {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "typePiece_id_Sequence")
    @SequenceGenerator(name = "typePiece_id_Sequence", sequenceName = "typePiece_ID_SEQ")
    Long pieceId;
    @Column(name = "typePiece")
    String typePiece;
}
