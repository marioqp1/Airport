package com.sw.airport.airport.repostories;

import com.sw.airport.airport.entities.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<RequestEntity,Long> {
}
