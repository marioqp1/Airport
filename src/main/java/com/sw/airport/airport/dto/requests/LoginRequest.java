package com.sw.airport.airport.dto.requests;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginRequest {


    private String email;
    private String password;

}
