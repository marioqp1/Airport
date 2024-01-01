package com.sw.airport.airport.dto.responses;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginResponse {

    private Long userId;
    private String name;
    private String email;

}
