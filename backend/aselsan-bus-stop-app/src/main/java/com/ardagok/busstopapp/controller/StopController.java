package com.ardagok.busstopapp.controller;


import com.ardagok.busstopapp.exception.StopIdNotFoundException;
import com.ardagok.busstopapp.entity.StopEntity;
import com.ardagok.busstopapp.service.StopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/stops", produces = "application/json")
public class StopController {

    @Autowired
    private final StopService stopService;

    public StopController(StopService stopService) {
        this.stopService = stopService;
    }

    @GetMapping
    public List<StopEntity> getBusStops() {
        return stopService.getBusStops();
    }

    @GetMapping(path = "/min")
    public Map<String, List<Object>> getStopsMin() {
        return stopService.getStopsMin();
    }

    @PostMapping
    public void registerNewStop(@RequestBody StopEntity stopEntity) {
        stopService.addNewBusStops(stopEntity);
    }

    @GetMapping(path = "/{id}")
    public StopEntity findStopById(@PathVariable long id) {
        return stopService.findStopById(id).orElseThrow(() -> new StopIdNotFoundException("Stop id: "+ id + " is not Found" ));
    }

}
