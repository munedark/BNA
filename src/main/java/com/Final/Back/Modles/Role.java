package com.Final.Back.Modles;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
public class Role {
    @Id
    @Column(name="Role",nullable=false,unique=true)
    private Long id;
    @Column(name = "roleName",nullable = false,unique = true)
    private String roleName;

}
