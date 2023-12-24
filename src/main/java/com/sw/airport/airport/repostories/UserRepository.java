package com.sw.airport.airport.repostories;

import com.sw.airport.airport.entities.UserEntity;
import com.sw.airport.airport.entities.UserLuggage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
//@EnableJpaRepositories
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findAllByNationalId(String nationalId);
    UserEntity findAllById(Long id);
    void deleteById(Long Id);


}
