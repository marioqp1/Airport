package com.sw.airport.airport.controllers;
import com.sw.airport.airport.dto.ApiResponse;
import com.sw.airport.airport.dto.UsersDto;
import com.sw.airport.airport.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;
    @GetMapping("{userId}")
    public ApiResponse<UsersDto> getUser(@PathVariable Long userId){
        ApiResponse<UsersDto> usersDtoApiResponse = userService.getUser(userId);
        return usersDtoApiResponse;
    }
    @PutMapping("/update/{userId}")
    public ApiResponse<UsersDto> updateUser(@RequestBody UsersDto usersDto,@PathVariable Long userId){
        ApiResponse<UsersDto> usersDtoApiResponse = userService.updateUser(userId,usersDto);
        return usersDtoApiResponse;
    }
    @PostMapping("")
    public ApiResponse<UsersDto> creatUser(@RequestBody UsersDto usersDto){
        ApiResponse<UsersDto> usersDtoApiResponse = userService.createUser(usersDto);
        return usersDtoApiResponse;

    }
    @DeleteMapping("{userId}/Delete")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }
    @GetMapping()
    public ApiResponse<List<UsersDto>> getAllUsers(){
        ApiResponse<List<UsersDto>> listApiResponse = userService.getUsers();
        return listApiResponse;
    }

}
