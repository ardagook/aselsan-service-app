package com.ardagok.busstopapp.controller;


import com.ardagok.busstopapp.entity.StopEntity;
import com.ardagok.busstopapp.service.StopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/bus/stops", produces = "application/json")
public class StopAppController {

    @Autowired
    private final StopService stopService;

    public StopAppController(StopService stopService) {
        this.stopService = stopService;
    }

    @GetMapping
    public List<StopEntity> getBusStops() {
        return stopService.getBusStops();
    }

    @GetMapping(path = "/min")
    public HashMap<String, LinkedList> getStopsMin() {
       return stopService.getStopsMin();
    }

    @PostMapping
    public void registerNewStop(@RequestBody StopEntity stopEntity) {
        stopService.addNewBusStops(stopEntity);

    }

    @GetMapping(path = "/{id}")
    public Optional<StopEntity> findStopById(@PathVariable long id) {
        return stopService.findStopById(id);
    }

}
