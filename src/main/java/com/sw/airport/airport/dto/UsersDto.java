package com.sw.airport.airport.dto;

import com.sw.airport.airport.entities.Request;
import com.sw.airport.airport.entities.UserLuggage;
import lombok.Data;

@Data
public class UsersDto {

    private Long id;
    private String name;
    private String email;
    private String mobileNum;
    private String nationalId;
    private Request request;
    private UserLuggage userLuggage;

}
