package com.ardagok.busstopapp.service;

import com.ardagok.busstopapp.entity.StopEntity;
import com.ardagok.busstopapp.repository.BusStopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class BusStopService {
    @Autowired
    private final BusStopRepository busStopRepository;

    public BusStopService(BusStopRepository busStopRepository) {
        this.busStopRepository = busStopRepository;
    }

    public List<StopEntity> getBusStops() {
        return busStopRepository.findAll();
    }

    @PostMapping
    public void addNewBusStops(StopEntity stopEntity) {
        busStopRepository.save(stopEntity);
    }


}
