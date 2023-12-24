package com.sw.airport.airport.repostories;
import com.sw.airport.airport.entities.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
 Airport findAirportByAirportName(String Name);
 Airport findAirportById(Long Id);
}
