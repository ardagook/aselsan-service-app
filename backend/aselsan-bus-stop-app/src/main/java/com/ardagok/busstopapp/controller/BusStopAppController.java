package com.ardagok.busstopapp.controller;


import com.ardagok.busstopapp.entity.StopEntity;
import com.ardagok.busstopapp.service.BusStopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/bus/stops")
public class BusStopAppController {

    @Autowired
    private final BusStopService busStopService;

    public BusStopAppController(BusStopService busStopService) {
        this.busStopService = busStopService;
    }

    @GetMapping
    public List<StopEntity> getBusStops() {
        return busStopService.getBusStops();
    }

    @PostMapping
    public void registerNewStop(@RequestBody StopEntity stopEntity) {
        busStopService.addNewBusStops(stopEntity);

    }

    @GetMapping(path = "/{id}")
    public Optional<StopEntity> findStopById(@PathVariable long id) {
        return busStopService.findStopById(id);
    }

}
