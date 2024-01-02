package com.sw.airport.airport.services;

import com.sw.airport.airport.dto.ApiResponse;
import com.sw.airport.airport.entities.AirportEntity;

public interface AirportService {
    ApiResponse<AirportEntity> createAirport(AirportEntity airport);
    void deleteAirport(Long id);


}
