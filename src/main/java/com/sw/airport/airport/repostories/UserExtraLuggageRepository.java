package com.sw.airport.airport.repostories;

import com.sw.airport.airport.entities.UserExtraLuggage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserExtraLuggageRepository extends JpaRepository<UserExtraLuggage,Long> {
}
