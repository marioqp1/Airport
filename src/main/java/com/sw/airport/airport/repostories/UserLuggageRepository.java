package com.sw.airport.airport.repostories;

import com.sw.airport.airport.entities.UserEntity;
import com.sw.airport.airport.entities.UserLuggage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLuggageRepository extends JpaRepository<UserLuggage,Long> {
UserLuggage findByUser(UserEntity userEntity);
UserLuggage findAllById(Long id);
}
