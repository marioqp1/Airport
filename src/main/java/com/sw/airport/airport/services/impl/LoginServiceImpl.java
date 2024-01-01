package com.sw.airport.airport.services.impl;

import com.sw.airport.airport.dto.ApiResponse;
import com.sw.airport.airport.dto.ApiResponseBuilder;
import com.sw.airport.airport.dto.requests.LoginRequest;
import com.sw.airport.airport.dto.responses.LoginResponse;
import com.sw.airport.airport.entities.UserEntity;
import com.sw.airport.airport.repostories.UserRepository;
import com.sw.airport.airport.services.LoginService;
import com.sw.airport.airport.utils.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class LoginServiceImpl implements LoginService {

    private final UserRepository userRepository;

    @Override
    public ApiResponse<LoginResponse> login(LoginRequest auth) {
        log.info("Login Started For Email :{}", auth.getEmail());
        ApiResponseBuilder<LoginResponse> builder = new ApiResponseBuilder<>();
        UserEntity user = userRepository.findByEmail(auth.getEmail()).orElse(null);

        if (Objects.equals(user, null)) {
            throw new RuntimeException("Email Not Found");
        }

        if (!user.getPassword().equals(Utils.getMd5(auth.getPassword()))){
            throw new RuntimeException("Incorrect Password !");
        }

        builder.setMessage("success");
        builder.setStatusCode(200);
        builder.setSuccess(true);
        builder.setEntity(
                LoginResponse.builder()
                        .email(user.getEmail())
                        .userId(user.getId())
                        .name(user.getName())
                .build());

        log.info("Login Ended For Email :{}", auth.getEmail());
        return builder.build();
    }


}
