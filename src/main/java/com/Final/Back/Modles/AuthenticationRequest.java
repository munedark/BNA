package com.Final.Back.Modles;


import lombok.*;
import org.springframework.stereotype.Service;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
    public class AuthenticationRequest implements Serializable {


        private String username;
        private String password;


    }

