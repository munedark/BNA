package com.Final.Back.Modles.DossierDebiteur;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@Embeddable
public class DossierId implements Serializable {
    private Long NumCtx;
    private String CodeStructure;
}
