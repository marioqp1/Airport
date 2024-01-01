package com.sw.airport.airport.services;

import com.sw.airport.airport.dto.ApiResponse;
import com.sw.airport.airport.dto.UsersDto;

import java.util.List;

public interface UserService {

    ApiResponse<UsersDto> createUser(UsersDto usersDto);
    ApiResponse<UsersDto> updateUser(Long userId, UsersDto usersDto);
    void deleteUser(Long userId);
    ApiResponse<List<UsersDto>> getUsers();
    ApiResponse<UsersDto> getUser(Long userId);



}
