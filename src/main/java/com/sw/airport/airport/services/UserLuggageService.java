package com.sw.airport.airport.services;

import com.sw.airport.airport.dto.UsersDto;
import com.sw.airport.airport.entities.UserLuggage;

public interface UserLuggageService {
    //UsersDto importLuggage(UsersDto usersDto, UserLuggage userLuggage );
    UserLuggage getUserLuggage(UsersDto usersDto);
}
