package com.sw.airport.airport.services;


import com.sw.airport.airport.dto.UsersDto;
import com.sw.airport.airport.entities.Request;

public interface RequestService {
    Request getRequest(UsersDto usersDto);
    boolean postRequest(Request request,UsersDto usersDto);


}
