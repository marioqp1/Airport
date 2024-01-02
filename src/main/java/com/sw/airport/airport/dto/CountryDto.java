package com.sw.airport.airport.dto;

import com.sw.airport.airport.entities.AirportEntity;

import java.util.List;

public class CountryDto {
    private Long id;
    private String CountryName;
    private List<AirportEntity> airports;
}
