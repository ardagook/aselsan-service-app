package com.ardagok.busstopapp.repository;

import com.ardagok.busstopapp.entity.StopEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StopRepository extends JpaRepository<StopEntity, Long> {

    //getBusServices()
}
