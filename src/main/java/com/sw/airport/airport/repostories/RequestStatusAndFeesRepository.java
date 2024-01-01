package com.sw.airport.airport.repostories;

import com.sw.airport.airport.entities.RequestStatusAndFeesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestStatusAndFeesRepository extends JpaRepository<RequestStatusAndFeesEntity,Long> {
}
