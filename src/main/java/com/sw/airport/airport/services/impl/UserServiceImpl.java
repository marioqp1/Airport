package com.sw.airport.airport.services.impl;

import com.sw.airport.airport.dto.*;
import com.sw.airport.airport.entities.RequestEntity;
import com.sw.airport.airport.entities.UserEntity;
import com.sw.airport.airport.repostories.UserRepository;
import com.sw.airport.airport.services.UserService;
import com.sw.airport.airport.utils.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public ApiResponse<UsersDto> createUser(UsersDto userDto) {
        log.info("Create User Request Started");
        ApiResponseBuilder<UsersDto> builder = new ApiResponseBuilder<>();
        String email = Utils.userEmailValidation(userDto.getEmail());

        UserEntity user = UserEntity
                .builder()
                .email(email)
                .name(userDto.getName())
                .password(Utils.getMd5(userDto.getPassword()))
                .mobileNum(userDto.getMobileNum())
                .nationalId(userDto.getNationalId())
                .build();

        userRepository.save(user);
        userDto.setId(user.getId());

        builder.setMessage("success");
        builder.setStatusCode(200);
        builder.setSuccess(true);
        builder.setEntity(userDto);
        log.info("Create User Request Ended");
        return builder.build();
    }

    @Override
    public ApiResponse<UsersDto> updateUser(Long userId, UsersDto userDto) {
        log.info("Update User Request Started");

        ApiResponseBuilder<UsersDto> builder = new ApiResponseBuilder<>();
        UserEntity user = userRepository.findById(userId).orElse(null);

        if (Objects.equals(user, null)){
            throw new RuntimeException("User Not Found");
        }

        user.setMobileNum(userDto.getMobileNum());
        if (!user.getPassword().equals(Utils.getMd5(userDto.getPassword()))){
            user.setPassword(Utils.getMd5(userDto.getPassword()));
        }

        userRepository.save(user);

        builder.setMessage("success");
        builder.setStatusCode(200);
        builder.setSuccess(true);
        builder.setEntity(userDto);
        log.info("Update User Request Ended");
        return builder.build();

    }

    @Override
    public void deleteUser(Long userId) {
        log.info("Delete User Request Started for id:{}", userId);
        UserEntity user = userRepository.findById(userId).orElse(null);
        if (Objects.equals(user, null)){
            throw new RuntimeException("User Not Found");
        }
        userRepository.deleteById(userId);
        log.info("Delete User Request Ended for id:{}", userId);
    }

    @Override
    public ApiResponse<List<UsersDto>> getUsers() {
        ApiResponseBuilder<List<UsersDto>> builder = new ApiResponseBuilder<>();
        List<UsersDto>userDtolist = new ArrayList<>();
        List<UserEntity>userEntityList = userRepository.findAll();
        for (UserEntity user:userEntityList) {
            List<RequestDto> requestDtoList = new ArrayList<>();
            List<RequestEntity>requestEntityList = user.getRequestEntities();
//            for (int i = 0; i < requestEntityList.size(); i++) {
//
//                    requestDtoList.add(
//                            RequestDto.builder()
//                                    .id(requestEntityList.get(i).getId())
//                                    .userId(requestEntityList.get(i).getUserId())
//                                    .weight(requestEntityList.get(i).getWeight())
//                                    .price(requestEntityList.get(i).getPrice())
//                                    .requestStatusAndFeesDtos(requestEntityList.get(i).getRequestStatusAndFeeEntities())
//                                    .build()
//                    );
//
//            }
//            UserLuggageDto.builder().id(user.getUserLuggageEntity().getId())
//                    .weight(user.getUserLuggageEntity().getWeight())
//                    .build()
            userDtolist.add(
                    UsersDto
                            .builder()
                            .id(user.getId())
                            .email(user.getEmail())
                            .name(user.getName())
                            .mobileNum(user.getMobileNum())
                            .nationalId(user.getNationalId())
                            .requestDto(user.getRequestEntities())
                            .userLuggageDto(user.getUserLuggageEntity())
                            .build()
            );
        }

        builder.setMessage("success");
        builder.setStatusCode(200);
        builder.setSuccess(true);
        builder.setEntity(userDtolist);
        log.info("Update User Request Ended");
        return builder.build();
    }

    @Override
    public ApiResponse<UsersDto> getUser(Long userId) {
        log.info("Get User Request Started for id:{}", userId);
        ApiResponseBuilder<UsersDto> builder = new ApiResponseBuilder<>();

        UserEntity user = userRepository.findById(userId).orElse(null);
        if (Objects.equals(user, null)){
            throw new RuntimeException("User Not Found");
        }

        builder.setMessage("success");
        builder.setStatusCode(200);
        builder.setSuccess(true);
        List<RequestDto> requestDtoList = new ArrayList<>();
        List<RequestEntity>requestEntityList = user.getRequestEntities();
//        for (int i = 0; i < requestEntityList.size(); i++) {
//
//            requestDtoList.add(
//                    RequestDto.builder()
//                            .id(requestEntityList.get(i).getId())
//                            .userId(requestEntityList.get(i).getUserId())
//                            .weight(requestEntityList.get(i).getWeight())
//                            .price(requestEntityList.get(i).getPrice())
//                            .requestStatusAndFeesDtos(requestEntityList.get(i).getRequestStatusAndFeeEntities())
//                            .build()
//            );

//        }
//        UserLuggageDto.builder().id(user.getUserLuggageEntity().getId())
//                .weight(user.getUserLuggageEntity().getWeight())
//                .build()
        builder.setEntity(
                UsersDto
                        .builder()
                        .id(user.getId())
                        .email(user.getEmail())
                        .name(user.getName())
                        .mobileNum(user.getMobileNum())
                        .nationalId(user.getNationalId())
                        .requestDto(user.getRequestEntities())
                        .userLuggageDto(user.getUserLuggageEntity())
                        .build()
        );
        log.info("Get User Request Ended for id:{}", userId);
        return builder.build();
    }

}
