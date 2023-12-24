package com.sw.airport.airport.controllers;

import com.sw.airport.airport.dto.UsersDto;
import com.sw.airport.airport.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
@RequiredArgsConstructor
@Log4j2
public class UserController {

    final private UserService userService;

    @GetMapping("")
    public List<UsersDto> getUsers(){
        log.info("Get Users request received: {}");
        try{
            List<UsersDto> usersDtos = userService.getAllUsers();
            return usersDtos;
        }catch (Exception e){
            log.error("Error while processing Get Users", e);
            throw new RuntimeException(e.getMessage());
        }
    }

    @PostMapping("")
    public UsersDto createUser(@RequestBody UsersDto request){
        log.info("Get Users request received: {}");
        try{
            return userService.createUser(request);
        }catch (Exception e){
            log.error("Error while processing Get Users", e);
            throw new RuntimeException(e.getMessage());
        }
    }

    @PostMapping("/update")
    public UsersDto updateUser(@RequestBody UsersDto request){
        log.info("Get Users request received: {}");
        try{
            return userService.updateUser(request.getId(),request);
        }catch (Exception e){
            log.error("Error while processing Get Users", e);
            throw new RuntimeException(e.getMessage());
        }
    }
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }


@GetMapping(path = {"/{id}"})
public UsersDto getUserById(@PathVariable("id") Long id){

    return userService.getUser(id);
  }
}
// url
// param
// path
// body
// header

