package com.sw.airport.airport.services.Impl;

import com.sw.airport.airport.dto.UsersDto;
import com.sw.airport.airport.entities.UserEntity;
import com.sw.airport.airport.entities.UserLuggage;
import com.sw.airport.airport.repostories.UserLuggageRepository;
import com.sw.airport.airport.repostories.UserRepository;
import com.sw.airport.airport.services.UserLuggageService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UserLuggageServiceImpl implements UserLuggageService {
    @Autowired
    private UserLuggageRepository userLuggageRepository;
    @Autowired
    private UserRepository userRepository;




    @Override
    public UserLuggage getUserLuggage(UsersDto usersDto) {
       return userLuggageRepository.findByUser(userRepository.findAllById(usersDto.getId()));
    }
}
