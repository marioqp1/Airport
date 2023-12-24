package com.sw.airport.airport.services;

import com.sw.airport.airport.dto.UsersDto;
import com.sw.airport.airport.entities.UserLuggage;

import java.util.List;

public interface UserService {

    List<UsersDto> getAllUsers();
    // TODO
    // create user
    UsersDto createUser(UsersDto usersDto);
    UsersDto updateUser(Long id,UsersDto usersDto);
    void deleteUser(Long id);
    UsersDto getUser(Long id);
   // UsersDto updateUserLuggage(Long id, UserLuggage userLuggage);

    // update user
    // delete user

}
