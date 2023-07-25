package com.ardagok.busstopapp.repository;

import com.ardagok.busstopapp.entity.StopEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusStopRepository extends JpaRepository<StopEntity,Long> {

    //getBusServices()
}
