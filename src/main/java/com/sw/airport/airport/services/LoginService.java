package com.sw.airport.airport.services;

import com.sw.airport.airport.dto.ApiResponse;
import com.sw.airport.airport.dto.requests.LoginRequest;
import com.sw.airport.airport.dto.responses.LoginResponse;

public interface LoginService {

    ApiResponse<LoginResponse> login(LoginRequest auth);

}
