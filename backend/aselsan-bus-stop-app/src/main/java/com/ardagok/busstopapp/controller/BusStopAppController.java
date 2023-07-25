package com.ardagok.busstopapp.controller;


import com.ardagok.busstopapp.entity.StopEntity;
import com.ardagok.busstopapp.service.BusStopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/bus/stops")
public class BusStopAppController {

    @Autowired
    public final BusStopService busStopService;

    public BusStopAppController(BusStopService busStopService) {
        this.busStopService = busStopService;
    }

    @GetMapping
    public List<StopEntity> getBusStops() {
        return busStopService.getBusStops();
    }


}
