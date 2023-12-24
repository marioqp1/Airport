package com.sw.airport.airport.repostories;

import com.sw.airport.airport.entities.Flights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightsRepository extends JpaRepository<Flights,Long> {
}
