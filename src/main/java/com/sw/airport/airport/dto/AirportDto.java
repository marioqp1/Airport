package com.sw.airport.airport.dto;

import com.sw.airport.airport.entities.FlightsEntity;

import java.util.ArrayList;
import java.util.List;

public class AirportDto {
    private Long id;
    private String airportName;
    private Long country;
    private List<FlightsEntity> flights = new ArrayList<>();

}
