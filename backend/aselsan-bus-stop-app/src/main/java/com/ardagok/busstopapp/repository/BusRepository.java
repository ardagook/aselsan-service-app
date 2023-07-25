package com.ardagok.busstopapp.repository;


import com.ardagok.busstopapp.entity.BusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<BusEntity, Long> {

}
