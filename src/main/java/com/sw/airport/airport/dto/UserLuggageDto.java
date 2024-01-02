package com.sw.airport.airport.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserLuggageDto {
    private Long id;
    private Integer weight;

}
