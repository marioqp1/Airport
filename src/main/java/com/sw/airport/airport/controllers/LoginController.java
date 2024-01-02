package com.sw.airport.airport.controllers;

import com.sw.airport.airport.dto.ApiResponse;
import com.sw.airport.airport.dto.requests.LoginRequest;
import com.sw.airport.airport.dto.responses.LoginResponse;
import com.sw.airport.airport.services.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/login")
public class LoginController {
    private final LoginService loginService;

    @PostMapping("")  // Change from @GetMapping to @PostMapping
    public ApiResponse<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        ApiResponse<LoginResponse> loginResponseApiResponse = loginService.login(loginRequest);
        return loginResponseApiResponse;
    }
}
