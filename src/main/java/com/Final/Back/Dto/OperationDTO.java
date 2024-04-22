package com.Final.Back.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor

public class OperationDTO {

        private String matriculeValidateur;
        private Date dateValidation;
        private String etatOperation;




}
