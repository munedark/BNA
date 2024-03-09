package com.Final.Back.Dto;


import com.Final.Back.Modles.Profile;
import com.Final.Back.Modles.Client;
import lombok.Data;

@Data
public class AuthCDto {

    private Client client;
    private Profile profile;
}
