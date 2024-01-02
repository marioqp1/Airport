package com.sw.airport.airport.dto;

import com.sw.airport.airport.entities.RequestEntity;
import com.sw.airport.airport.entities.UserLuggageEntity;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Builder
public class UsersDto {

    private Long id;
    @NotBlank(message = "Name Can`t be Null")
    private String name;
    @NotBlank(message = "Name Can`t be Null")
    private String email;
    @NotBlank(message = "Password Can`t be Null")
    private String password;
    @NotBlank(message = "MobileNum Can`t be Null")
    private String mobileNum;
    @NotBlank(message = "NationalId Can`t be Null")
    private String nationalId;
    private List<RequestEntity> requestDto;
    private UserLuggageEntity userLuggageDto;

}
