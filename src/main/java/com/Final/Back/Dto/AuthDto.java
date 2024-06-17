package com.Final.Back.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class AuthDto {
    String cin;
    String password;
}
