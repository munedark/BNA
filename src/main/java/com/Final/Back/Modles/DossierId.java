package com.Final.Back.Modles;

import lombok.*;

import javax.persistence.Embeddable;
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@Embeddable
public class DossierId {
    private Long NumCtx;
    private String CodeStructure;
}
