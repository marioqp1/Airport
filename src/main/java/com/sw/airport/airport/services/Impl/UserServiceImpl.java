package com.sw.airport.airport.services.Impl;

import com.sw.airport.airport.dto.UsersDto;
import com.sw.airport.airport.entities.UserEntity;
import com.sw.airport.airport.entities.UserLuggage;
import com.sw.airport.airport.repostories.UserLuggageRepository;
import com.sw.airport.airport.repostories.UserRepository;
import com.sw.airport.airport.services.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
@Log4j2
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserLuggageRepository userLuggageRepository;
    public List<UsersDto> getAllUsers(){
        List<UserEntity> userEntities = userRepository.findAll();
        List<UsersDto> usersDtos = new ArrayList<>();
        for (UserEntity user : userEntities){
            UsersDto dto = new UsersDto();
            dto.setId(user.getId());
            dto.setName(user.getName());
            dto.setMobileNum(user.getMobileNum());
            dto.setEmail(user.getEmail());
            dto.setNationalId(user.getNationalId());
            dto.setUserLuggage(user.getUserLuggage());
            usersDtos.add(dto);
        }
        return usersDtos;
    }

    @Override
    public UsersDto createUser(UsersDto request){
        UserEntity user = new UserEntity();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setNationalId(request.getNationalId());
        user.setMobileNum(request.getMobileNum());
        userRepository.save(user);
        request.setId(user.getId());
        return request;
    }

    @Override
    public UsersDto updateUser(Long id,UsersDto usersDto) {
        UserEntity userEntity = new UserEntity();
        userEntity = userRepository.findAllById(id);
        userEntity.setName(usersDto.getName());
        userEntity.setEmail(usersDto.getEmail());
        userEntity.setNationalId(usersDto.getNationalId());
        userEntity.setMobileNum(usersDto.getMobileNum());
        userEntity.setUserLuggage(usersDto.getUserLuggage());
        userRepository.save(userEntity);
        return usersDto;
    }

    @Override
    public void deleteUser(Long id){

        userRepository.deleteById(id);
    }
    public UsersDto getUser(Long id){
        UsersDto usersDto = new UsersDto();
        UserEntity userEntity = userRepository.findAllById(id);
        usersDto.setEmail(userEntity.getEmail());
        usersDto.setName(userEntity.getName());
        usersDto.setMobileNum(userEntity.getMobileNum());
        usersDto.setNationalId(userEntity.getNationalId());
        usersDto.setId(userEntity.getId());
        return usersDto;


    }


}
